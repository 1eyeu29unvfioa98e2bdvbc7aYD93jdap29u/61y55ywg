package ru.pavlov.palestra.presentation.modules.registration.step1.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface FirstStepVmContract {

    interface ViewModel : MvpViewModel {
//        var registrationStep: RegistrationSteps
//            @Bindable get
    }

    interface Presenter : MvpPresenter<ViewModel> {

    }
}