package ru.pavlov.palestra.presentation.modules.authentication.contract

import com.vershininds.mixture.router.MvpRouter

interface AuthRouterContract {

    interface Router : MvpRouter<Presenter> {

    }

    interface Presenter : MvpRouter.Listener {

    }

}