package palestra.viper.router;

/**
 * Created by REGION\ds.vershinin on 9/2/16.
 */
public abstract class AbstractRouter<L extends MvpRouter.Listener> implements MvpRouter<L> {
    private L listener;

    @Override
    public void setListener(L listener) {
        this.listener = listener;
    }

    protected L getListener() {
        return listener;
    }
}
