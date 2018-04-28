package ru.pavlov.palestra.presentation.modules.registration.parent.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface RegistrationVmContract {

    interface ViewModel : MvpViewModel {

    }

    interface Presenter : MvpPresenter<ViewModel> {

    }
}