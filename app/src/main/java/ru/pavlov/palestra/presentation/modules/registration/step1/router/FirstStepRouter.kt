package ru.pavlov.palestra.presentation.modules.registration.step1.router

import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.registration.step1.contract.FirstStepRouterContract
import javax.inject.Inject

class FirstStepRouter @Inject constructor() : AbstractRouter<FirstStepRouterContract.Presenter>(), FirstStepRouterContract.Router {
    override fun showSecondRegistrationScreen() {
    }
}