package ru.pavlov.palestra.presentation.modules.registration.step1.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import ru.pavlov.palestra.presentation.modules.registration.step1.contract.FirstStepRouterContract
import ru.pavlov.palestra.presentation.modules.registration.step1.contract.FirstStepVmContract
import ru.pavlov.palestra.presentation.modules.registration.step1.viewmodel.FirstStepViewModel
import javax.inject.Inject

class FirstStepPresenter @Inject constructor() : AbstractPresenter<FirstStepVmContract.ViewModel>(FirstStepViewModel()),
        FirstStepRouterContract.Presenter, FirstStepVmContract.Presenter {
}