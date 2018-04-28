package ru.pavlov.palestra.presentation.modules.authentication.contract

import android.view.View
import com.vershininds.mixture.router.MvpRouter
import com.vershininds.mixture.view.AndroidComponent

interface AuthRouterContract {

    interface Router : MvpRouter<Presenter> {
        fun showRegisterScreen(androidComponent: AndroidComponent, sharedView: View)
    }

    interface Presenter : MvpRouter.Listener {

    }

}