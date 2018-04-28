package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import com.vershininds.mixture.router.MvpRouter
import com.vershininds.mixture.view.AndroidComponent

interface WelcomeRouterContract {

    interface Router : MvpRouter<Presenter> {
        fun goAuthScreen(androidComponent: AndroidComponent)
    }

    interface Presenter : MvpRouter.Listener {}
}