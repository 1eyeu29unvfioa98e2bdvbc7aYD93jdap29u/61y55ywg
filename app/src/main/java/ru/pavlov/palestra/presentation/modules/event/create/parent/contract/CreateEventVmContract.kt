package ru.pavlov.palestra.presentation.modules.event.create.parent.contract

import palestra.viper.presenter.MvpPresenter
import palestra.viper.viewmodel.MvpViewModel

interface CreateEventVmContract {
    interface ViewModel : MvpViewModel {
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun nextStepClick()
        fun onBackPressed()
    }
}