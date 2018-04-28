package ru.pavlov.palestra.presentation.modules.authentication.presenter

import android.view.View
import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthInteractorContract
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthRouterContract
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthVmContract
import ru.pavlov.palestra.presentation.modules.authentication.viewmodel.AuthViewModel
import javax.inject.Inject

class AuthPresenter @Inject constructor(
        val interactor: AuthInteractorContract.Interactor,
        val router: AuthRouterContract.Router) : AbstractPresenter<AuthVmContract.ViewModel>(AuthViewModel()),
        AuthVmContract.Presenter, AuthInteractorContract.Presenter, AuthRouterContract.Presenter {

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)

        interactor.apply {
            setListener(this@AuthPresenter)
        }

        router.apply {
            setListener(this@AuthPresenter)
        }

    }

    override fun detachView() {
        interactor.apply {
            setListener(null)
        }

        router.apply {
            setListener(null)
        }

        super.detachView()
    }

    override fun onRegisterClick(sharedView: View) {
        applyAction({ router.showRegisterScreen(androidComponent, sharedView) })
    }
}