package palestra.viper.view;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

public interface AndroidComponent {
    Activity getActivity();
    FragmentManager getSupportFragmentManager();
}
