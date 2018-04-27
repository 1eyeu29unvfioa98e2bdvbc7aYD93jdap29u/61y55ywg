package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface DetailEventVmContract {
    interface ViewModel : MvpViewModel {
    }

    interface Presenter : MvpPresenter<ViewModel> {
    }
}