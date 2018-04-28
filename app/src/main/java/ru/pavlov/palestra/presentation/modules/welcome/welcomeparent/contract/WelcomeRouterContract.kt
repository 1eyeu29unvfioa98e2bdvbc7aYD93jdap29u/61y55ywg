package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import android.view.View
import com.vershininds.mixture.router.MvpRouter
import com.vershininds.mixture.view.AndroidComponent

interface WelcomeRouterContract {

    interface Router : MvpRouter<Presenter> {
        fun showAuthScreen(androidComponent: AndroidComponent, sharedView: View)
    }

    interface Presenter : MvpRouter.Listener {
    }
}