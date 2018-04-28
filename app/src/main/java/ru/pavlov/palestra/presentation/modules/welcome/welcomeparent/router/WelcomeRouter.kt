package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.router

import android.content.Intent
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.authentication.AuthModuleContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import javax.inject.Inject

class WelcomeRouter @Inject constructor(
        private val authModuleContract: AuthModuleContract) : AbstractRouter<WelcomeRouterContract.Presenter>(), WelcomeRouterContract.Router {

    override fun goAuthScreen(androidComponent: AndroidComponent) {
        val activity = androidComponent.activity
        authModuleContract.createIntent(activity).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(this)
        }
    }
}