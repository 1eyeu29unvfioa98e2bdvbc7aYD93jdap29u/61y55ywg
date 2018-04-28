package ru.pavlov.palestra.presentation.modules.registration.parent.contract

import com.vershininds.mixture.interactor.MvpInteractor
import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface RegistrationInteractorContract {

    interface Interactor : MvpInteractor<Presenter> {

    }

    interface Presenter : MvpInteractor.Listener {
        
    }
}