package ru.pavlov.palestra.presentation.modules.event.create.addevent.contract

import palestra.viper.presenter.MvpPresenter
import palestra.viper.viewmodel.MvpViewModel

interface AddEventVmContract {
    interface ViewModel : MvpViewModel {
    }

    interface Presenter : MvpPresenter<ViewModel> {

    }
}