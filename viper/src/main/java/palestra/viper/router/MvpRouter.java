package palestra.viper.router;

public interface MvpRouter<L extends MvpRouter.Listener> {
    interface Listener {}

    void setListener(L listener);
}
