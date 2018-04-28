package ru.pavlov.palestra.presentation.modules.registration.parent.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(RegistrationDiModule::class))
interface RegistrationComponent {
    fun getViewModel() : RegistrationVmContract.ViewModel
    fun getPresenter() : RegistrationVmContract.Presenter
}