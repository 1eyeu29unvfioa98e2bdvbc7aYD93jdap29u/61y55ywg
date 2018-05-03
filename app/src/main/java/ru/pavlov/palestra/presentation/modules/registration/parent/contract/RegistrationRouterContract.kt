package ru.pavlov.palestra.presentation.modules.registration.parent.contract

import com.vershininds.mixture.router.MvpRouter
import com.vershininds.mixture.view.AndroidComponent

interface RegistrationRouterContract {

    interface Presenter : MvpRouter.Listener {
    }

    interface Router : MvpRouter<Presenter> {
        fun showFirstRegistrationScreen(androidComponent: AndroidComponent)
        fun showSecondRegistrationScreen(androidComponent: AndroidComponent)
        fun showThirdRegistrationScreen(androidComponent: AndroidComponent)
        fun showFourRegistrationScreen(androidComponent: AndroidComponent)
        fun showFiveRegistrationScreen(androidComponent: AndroidComponent)
    }
}