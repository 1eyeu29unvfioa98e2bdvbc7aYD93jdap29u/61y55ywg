package ru.pavlov.palestra.presentation.modules.registration.step1.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.registration.step1.contract.FirstStepVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(FirstStepDiModule::class))
interface FirstStepCompenent {
    fun getViewModel() : FirstStepVmContract.ViewModel
    fun getPresenter() : FirstStepVmContract.Presenter
}