package palestra.viper.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import org.parceler.Parcels;

import palestra.viper.helper.PresenterStorage;
import palestra.viper.presenter.MvpPresenter;
import palestra.viper.viewmodel.MvpViewModel;


public abstract class AbstractDialogFragment<VM extends MvpViewModel, P extends MvpPresenter<VM>>
        extends DialogFragment implements AndroidComponent {

    private static final String VM_KEY = AbstractDialogFragment.class.getSimpleName() + "_VM";

    private P presenter;
    private VM viewModel;

    protected abstract void injectDi();
    protected abstract P createPresenter();
    protected abstract VM createViewModel();

    public P getPresenter() {
        return presenter;
    }

    protected VM getViewModel() {
        return viewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDi();

        if (null == savedInstanceState) {
            viewModel = createViewModel();
            presenter = createPresenter();
        } else {
            viewModel = Parcels.unwrap(savedInstanceState.getParcelable(VM_KEY));
            presenter = PresenterStorage.getInstance().evict(getViewModel().getId());
            if (presenter == null) {
                presenter = createPresenter();
            } else {
                VM presenterVm = presenter.getViewModel();
                if (presenterVm != null) viewModel = presenterVm;
            }
        }

        attachView();
    }

    @Override
    public void onStart() {
        super.onStart();

        beforeViewAttached();
        attachView();
        afterViewAttached();
    }

    @Override
    public void onStop() {
        beforeViewDetached();
        presenter.detachView();
        afterViewDetached();

        if(getActivity().isChangingConfigurations()) {
            PresenterStorage.getInstance().save(getViewModel().getId(), presenter);
        } else {
            presenter.destroy();
        }

        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(VM_KEY, Parcels.wrap(getViewModel()));

        super.onSaveInstanceState(outState);
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return getFragmentManager();
    }

    protected void beforeViewAttached() {}
    protected void afterViewAttached() {}

    protected void beforeViewDetached() {}
    protected void afterViewDetached() {}

    private void attachView(){
        if (!presenter.isAttachedView()) presenter.attachView(getViewModel(), this);
    }
}