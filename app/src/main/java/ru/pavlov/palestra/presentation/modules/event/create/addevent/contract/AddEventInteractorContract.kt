package ru.pavlov.palestra.presentation.modules.event.create.addevent.contract

import com.vershininds.mixture.interactor.MvpInteractor

interface AddEventInteractorContract {
    interface Interactor : MvpInteractor<Presenter> {
    }

    interface Presenter : MvpInteractor.Listener {

    }
}