package ru.pavlov.palestra.presentation.modules.authentication.contract

import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface AuthVmContract {

    interface ViewModel : MvpViewModel {

    }

    interface Presenter : MvpPresenter<ViewModel> {

    }

}