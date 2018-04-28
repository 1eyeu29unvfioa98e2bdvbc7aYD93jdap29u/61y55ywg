package ru.pavlov.palestra.presentation.modules.authentication.router

import android.support.v4.view.ViewCompat
import android.view.View
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthRouterContract
import ru.pavlov.palestra.presentation.modules.registration.parent.RegistrationModuleContract
import javax.inject.Inject

class AuthRouter @Inject constructor(
        val registrationModuleContract: RegistrationModuleContract) : AbstractRouter<AuthRouterContract.Presenter>(),
        AuthRouterContract.Router {

    override fun showRegisterScreen(androidComponent: AndroidComponent, sharedView: View) {
        val activity = androidComponent.activity
        registrationModuleContract.createIntent(activity).apply {
            displayActivityWithSharedView(activity, this, sharedView, ViewCompat.getTransitionName(sharedView))
        }
    }
}