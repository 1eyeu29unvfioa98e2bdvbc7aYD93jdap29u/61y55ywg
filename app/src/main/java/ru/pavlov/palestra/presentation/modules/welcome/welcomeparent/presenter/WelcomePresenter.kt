package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.presenter

import palestra.viper.presenter.AbstractPresenter
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeViewModelContract
import javax.inject.Inject

class WelcomePresenter() : AbstractPresenter<WelcomeViewModelContract.ViewModel>(),
        WelcomeViewModelContract.Presenter, WelcomeRouterContract.Presenter {

    private lateinit var router: WelcomeRouterContract.Router

    @Inject constructor(router: WelcomeRouterContract.Router) : this() {
        this.router = router
    }

    override fun enterAppClick() {
        router.goAuthScreen()
    }
}