package ru.pavlov.palestra.presentation.modules.registration.parent.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationInteractorContract
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationRouterContract
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract
import ru.pavlov.palestra.presentation.modules.registration.parent.viewmodel.RegistrationViewModel
import javax.inject.Inject

class RegistrationPresenter @Inject constructor(
        val registrationInteractorContract: RegistrationInteractorContract.Interactor,
        val registrationRouterContract: RegistrationRouterContract.Router) : AbstractPresenter<RegistrationVmContract.ViewModel>(RegistrationViewModel()),
        RegistrationVmContract.Presenter, RegistrationRouterContract.Presenter, RegistrationInteractorContract.Presenter {

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)

    }
}