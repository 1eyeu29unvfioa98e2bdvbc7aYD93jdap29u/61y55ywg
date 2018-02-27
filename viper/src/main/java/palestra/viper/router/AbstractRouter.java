package palestra.viper.router;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import palestra.viper.view.AndroidComponent;

public abstract class AbstractRouter<L extends MvpRouter.Listener> implements MvpRouter<L> {
    private L listener;

    @Override
    public void setListener(L listener) {
        this.listener = listener;
    }

    protected L getListener() {
        return listener;
    }

    protected void displayFragmentAdd(AndroidComponent androidComponent, Fragment fragment, String tag, int fragmentContainerId) {
        final FragmentManager fragmentManager = androidComponent.getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction()
                    .add(fragmentContainerId, fragment, tag)
                    .addToBackStack(null)
                    .commit();
        }
    }

    protected void displayFragmentReplace(AndroidComponent androidComponent, Fragment fragment, String tag, int fragmentContainerId) {
        final FragmentManager fragmentManager = androidComponent.getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction()
                    .replace(fragmentContainerId, fragment, tag)
                    .commit();
        }
    }
}
