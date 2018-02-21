package palestra.viper.presenter;

import android.support.annotation.CallSuper;

import palestra.viper.view.AndroidComponent;
import palestra.viper.viewmodel.MvpViewModel;


/**
 * Created by REGION\ds.vershinin on 9/2/16.
 */
public abstract class AbstractPresenter<VM extends MvpViewModel>
        implements MvpPresenter<VM> {

    private final String TAG = AbstractPresenter.this.getClass().getSimpleName();

    VM viewModel;
    AndroidComponent component;

    @CallSuper
    @Override
    public void attachView(VM viewModel, AndroidComponent component) {
        this.viewModel = viewModel;
        this.component = component;
    }

    @CallSuper
    @Override
    public void detachView() {
        this.component = null;
                /*
        viewModel live while live presenter,
        viewModel is created at first time when presenter created
        */
//        this.viewModel = null;
    }

    @Override
    public boolean isAttachedView() {
        return component != null;
    }

    @CallSuper
    @Override
    public void destroy() {
    }

    protected AndroidComponent getAndroidComponent() {
        return component;
    }

    @Override
    public VM getViewModel() {
        return viewModel;
    }
}