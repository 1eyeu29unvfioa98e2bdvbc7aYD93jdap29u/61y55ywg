package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.router

import android.content.Intent
import android.support.v4.view.ViewCompat
import android.view.View
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.authentication.AuthModuleContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import javax.inject.Inject

class WelcomeRouter @Inject constructor(
        private val authModuleContract: AuthModuleContract) : AbstractRouter<WelcomeRouterContract.Presenter>(), WelcomeRouterContract.Router {

    override fun showAuthScreen(androidComponent: AndroidComponent, sharedView: View) {
        authModuleContract.createIntent(androidComponent.activity).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            displayActivityWithSharedView(androidComponent, this, sharedView, ViewCompat.getTransitionName(sharedView))
        }
    }
}