package ru.pavlov.palestra.presentation.modules.registration.step1.contract

import com.vershininds.mixture.router.MvpRouter

interface FirstStepRouterContract {
    interface Presenter : MvpRouter.Listener {
    }

    interface Router : MvpRouter<Presenter> {
        fun showSecondRegistrationScreen()
    }
}