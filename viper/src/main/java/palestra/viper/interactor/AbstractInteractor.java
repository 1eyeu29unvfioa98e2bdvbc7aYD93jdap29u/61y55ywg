package palestra.viper.interactor;

import android.support.annotation.CallSuper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public abstract class AbstractInteractor <L extends MvpInteractor.Listener> implements MvpInteractor<L> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<Long> executedOperations = new ArrayList();
    private final Queue<PendingResult> buffer = new LinkedList<>();
    private L listener;

    @Override
    public State getState() {
        return executedOperations.isEmpty() ? State.IDLE : State.WORKING;
    }

    @CallSuper
    @Override
    public void setListener(L listener) {
        this.listener = listener;

        if (this.listener != null) {
            redeliverResults();
        }

        recreateCompositeSubscription();
    }

    @CallSuper
    @Override
    public void destroy() {
        clearSubscriptions();
        buffer.clear();
    }

    @Override
    public void reset() {
        cancelPreviousRequests();
    }

    protected L getListener() {
        return listener;
    }

    protected void cacheSubscription(Long id, Disposable subscription) {
        executedOperations.add(id);
        compositeDisposable.add(subscription);
    }

    protected void clearSubscriptions() {
        buffer.clear();
        executedOperations.clear();
        compositeDisposable.dispose();
    }

    protected <T> void deliverResult(PendingResult<T, L> pendingResult) {
        try {
            pendingResult.deliver(getListener());
        } catch (Exception e) {
            Timber.e(e);
            buffer.add(pendingResult);
            Timber.e("deliverResult: " + e.getMessage());
        }
    }

    private void redeliverResults() {
        PendingResult result;
        while ((result = buffer.poll()) != null) {
            deliverResult(result);
        }
    }

    protected <T> void execute(Observable<T> observable, final ResultFactory<T, L> resultFactory) {
        final Long id = System.nanoTime();

        Disposable subscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<T>() {
                    @Override
                    public void onNext(T t) {
                        deliverResult(resultFactory.create(t, null));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                        markOperationFinished(id);
                        deliverResult(resultFactory.create(null, e));
                    }

                    @Override
                    public void onComplete() {
                        markOperationFinished(id);
                    }
                });

        cacheSubscription(id, subscription);
    }

    protected void cancelPreviousRequests() {
        clearSubscriptions();
        recreateCompositeSubscription();
    }

    private void recreateCompositeSubscription() {
        if (compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
    }

    private void markOperationFinished(Long taskId) {
        executedOperations.remove(taskId);
    }

    protected interface ResultFactory<T, L> {
        PendingResult<T, L> create(T data, Throwable throwable);
    }
}