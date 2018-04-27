package ru.pavlov.palestra.presentation.modules.event.create.addevent.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface AddEventVmContract {
    interface ViewModel : MvpViewModel {
    }

    interface Presenter : MvpPresenter<ViewModel> {

    }
}