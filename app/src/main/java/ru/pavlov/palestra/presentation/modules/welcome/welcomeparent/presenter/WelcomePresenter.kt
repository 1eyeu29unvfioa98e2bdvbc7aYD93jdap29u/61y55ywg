package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.viewmodel.WelcomeViewModel
import javax.inject.Inject

class WelcomePresenter @Inject constructor(
        val router: WelcomeRouterContract.Router) : AbstractPresenter<WelcomeVmContract.ViewModel>(WelcomeViewModel()),
        WelcomeVmContract.Presenter, WelcomeRouterContract.Presenter {

    override fun enterAppClick() {
        router.goAuthScreen()
    }
}