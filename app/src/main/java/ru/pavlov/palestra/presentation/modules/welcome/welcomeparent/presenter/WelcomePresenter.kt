package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeViewModelContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.viewmodel.WelcomeViewModel
import javax.inject.Inject

class WelcomePresenter() : AbstractPresenter<WelcomeViewModelContract.ViewModel>(WelcomeViewModel()),
        WelcomeViewModelContract.Presenter, WelcomeRouterContract.Presenter {

    private lateinit var router: WelcomeRouterContract.Router

    @Inject constructor(router: WelcomeRouterContract.Router) : this() {
        this.router = router
    }

    override fun enterAppClick() {
        router.goAuthScreen()
    }
}