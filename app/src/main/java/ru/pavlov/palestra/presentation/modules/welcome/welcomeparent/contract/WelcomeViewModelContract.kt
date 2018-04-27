package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface WelcomeViewModelContract {
    interface ViewModel : MvpViewModel {}

    interface Presenter : MvpPresenter<ViewModel> {
        fun enterAppClick()
    }
}