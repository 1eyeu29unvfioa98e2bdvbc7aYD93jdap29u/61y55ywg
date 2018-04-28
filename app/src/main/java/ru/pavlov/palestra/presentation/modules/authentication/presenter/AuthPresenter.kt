package ru.pavlov.palestra.presentation.modules.authentication.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthInteractorContract
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthRouterContract
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthVmContract
import ru.pavlov.palestra.presentation.modules.authentication.viewmodel.AuthViewModel
import javax.inject.Inject

class AuthPresenter @Inject constructor(
        val interactor: AuthInteractorContract.Interactor,
        val router: AuthRouterContract.Router) : AbstractPresenter<AuthVmContract.ViewModel>(AuthViewModel()),
        AuthVmContract.Presenter, AuthInteractorContract.Presenter, AuthRouterContract.Presenter {
}