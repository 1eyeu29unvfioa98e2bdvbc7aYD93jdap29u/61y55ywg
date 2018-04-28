package ru.pavlov.palestra.presentation.modules.authentication.contract

import android.view.View
import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel

interface AuthVmContract {

    interface ViewModel : MvpViewModel {

    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun onRegisterClick(sharedView: View)
    }

}