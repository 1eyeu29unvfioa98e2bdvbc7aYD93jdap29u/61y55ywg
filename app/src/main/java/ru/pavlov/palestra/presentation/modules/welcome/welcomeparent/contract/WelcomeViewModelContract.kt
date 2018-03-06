package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import palestra.viper.presenter.MvpPresenter
import palestra.viper.viewmodel.MvpViewModel

interface WelcomeViewModelContract {
    interface ViewModel : MvpViewModel {}

    interface Presenter : MvpPresenter<ViewModel> {
        fun enterAppClick()
    }
}