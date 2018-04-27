package ru.pavlov.palestra.presentation.modules.event.create.parent.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface CreateEventVmContract {
    interface ViewModel : MvpViewModel {
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun nextStepClick()
        fun onBackPressed()
    }
}