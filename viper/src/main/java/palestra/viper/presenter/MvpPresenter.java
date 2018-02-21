package palestra.viper.presenter;

import palestra.viper.view.AndroidComponent;
import palestra.viper.viewmodel.MvpViewModel;

public interface MvpPresenter<VM extends MvpViewModel> {
    void attachView(VM viewModel, AndroidComponent component);
    void detachView();
    boolean isAttachedView();
    VM getViewModel();
    void destroy();
}