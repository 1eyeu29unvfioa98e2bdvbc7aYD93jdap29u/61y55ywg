package palestra.viper.viewmodel;

import android.databinding.Observable;

public interface MvpViewModel extends Observable {
    String getId();
    void invalidate();
}
