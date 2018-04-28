package ru.pavlov.palestra.presentation.modules.registration.parent.contract

import android.databinding.Bindable
import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface RegistrationVmContract {

    enum class RegistrationSteps {
        STEP1, STEP2, STEP3, STEP4, STEP5
    }

    interface ViewModel : MvpViewModel {
        var registrationStep: RegistrationSteps
            @Bindable get
    }

    interface Presenter : MvpPresenter<ViewModel> {

    }
}