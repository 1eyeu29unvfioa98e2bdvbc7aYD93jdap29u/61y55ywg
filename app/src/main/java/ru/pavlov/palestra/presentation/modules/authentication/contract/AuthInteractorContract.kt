package ru.pavlov.palestra.presentation.modules.authentication.contract

import com.vershininds.mixture.interactor.MvpInteractor

interface AuthInteractorContract {

    interface Interactor : MvpInteractor<Presenter> {

    }

    interface Presenter : MvpInteractor.Listener {

    }

}