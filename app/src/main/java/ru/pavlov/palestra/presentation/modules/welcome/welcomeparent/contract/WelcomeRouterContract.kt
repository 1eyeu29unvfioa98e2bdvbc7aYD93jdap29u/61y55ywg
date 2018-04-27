package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import com.vershininds.mixture.router.MvpRouter

interface WelcomeRouterContract {
    interface Router : MvpRouter<Presenter> {
        fun goAuthScreen()
    }

    interface Presenter : MvpRouter.Listener {}
}