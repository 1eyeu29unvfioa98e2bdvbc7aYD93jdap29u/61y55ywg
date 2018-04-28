package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract

import android.databinding.Bindable
import android.view.View
import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.viewmodel.MvpViewModel
import ru.pavlov.palestra.data.models.presentation.WelcomeCard

interface WelcomeVmContract {
    interface ViewModel : MvpViewModel {
        var welcomeCards: List<WelcomeCard>
            @Bindable get
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun enterAppClick(sharedView: View)
    }
}