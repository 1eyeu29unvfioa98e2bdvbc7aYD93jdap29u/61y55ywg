package ru.pavlov.palestra.presentation.modules.registration.parent.contract

import com.vershininds.mixture.router.MvpRouter

interface RegistrationRouterContract {

    interface Router : MvpRouter<Presenter> {

    }

    interface Presenter : MvpRouter.Listener {

    }
}