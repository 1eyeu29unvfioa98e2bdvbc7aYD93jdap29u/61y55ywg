package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import palestra.viper.router.MvpRouter

interface WelcomeRouterContract {
    interface Router : MvpRouter<Presenter> {
        fun goAuthScreen()
    }

    interface Presenter : MvpRouter.Listener {}
}