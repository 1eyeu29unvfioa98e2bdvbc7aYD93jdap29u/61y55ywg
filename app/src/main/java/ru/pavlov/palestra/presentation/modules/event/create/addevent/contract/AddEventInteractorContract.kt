package ru.pavlov.palestra.presentation.modules.event.create.addevent.contract

import palestra.viper.interactor.MvpInteractor
import palestra.viper.presenter.MvpPresenter
import palestra.viper.viewmodel.MvpViewModel

interface AddEventInteractorContract {
    interface Interactor : MvpInteractor<Presenter> {
    }

    interface Presenter : MvpInteractor.Listener {

    }
}