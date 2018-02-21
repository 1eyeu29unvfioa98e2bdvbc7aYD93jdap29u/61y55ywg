package palestra.viper.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.parceler.Parcels;

import palestra.viper.helper.PresenterStorage;
import palestra.viper.presenter.MvpPresenter;
import palestra.viper.viewmodel.MvpViewModel;


public abstract class AbstractActivity<VM extends MvpViewModel, P extends MvpPresenter<VM>>
        extends AppCompatActivity implements AndroidComponent {

    private static final String VM_KEY = AbstractActivity.class.getSimpleName() + "_VM";

    private P presenter;
    private VM viewModel;

    protected abstract void injectDi();
    protected abstract P createPresenter();
    protected abstract VM createViewModel();

    protected Toolbar mToolbar;

    public P getPresenter() {
        return presenter;
    }

    protected VM getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        attachView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        attachView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        attachView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        beforeViewAttached();
        attachView();
        afterViewAttached();
    }

    @Override
    protected void onStop() {
        beforeViewDetached();
        presenter.detachView();
        afterViewDetached();

        if(isChangingConfigurations()) {
            PresenterStorage.getInstance().save(getViewModel().getId(), presenter);
        } else {
            presenter.destroy();
        }

        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(VM_KEY, Parcels.wrap(getViewModel()));

        super.onSaveInstanceState(outState);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    private void attachView(){
        if (!presenter.isAttachedView()) presenter.attachView(getViewModel(), this);
    }

//    @Nullable
//    protected Toolbar getToolbar() {
//        if (mToolbar == null) {
//            mToolbar = findViewById(R.id.toolbar);
//        }
//        return mToolbar;
//    }
//
//    protected void setToolbar() {
//        this.setToolbar(true, true, -1);
//    }

//    protected void setToolbar(@DrawableRes int upButtonIndicator) {
//        this.setToolbar(true, true, upButtonIndicator);
//    }
//
//    protected void setToolbar(boolean displayTitle) {
//        this.setToolbar(displayTitle, true, -1);
//    }
//
//    protected void setToolbar(boolean displayTitle, boolean displayUpButton, @DrawableRes int upButtonIndicator) {
//        Toolbar toolbar = getToolbar();
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(displayUpButton);
//            actionBar.setDisplayShowTitleEnabled(displayTitle);
//            actionBar.setHomeButtonEnabled(displayUpButton);
//            if (upButtonIndicator != -1) {
//                actionBar.setHomeAsUpIndicator(upButtonIndicator);
//            }
//            actionBar.setDisplayShowCustomEnabled(true);
//        } else {
//            throw new NullPointerException("Error: set toolbar in layout or do not call setToolbar()");
//        }
//    }

    protected void beforeViewAttached() {}
    protected void afterViewAttached() {}

    protected void beforeViewDetached() {}
    protected void afterViewDetached() {}

}
