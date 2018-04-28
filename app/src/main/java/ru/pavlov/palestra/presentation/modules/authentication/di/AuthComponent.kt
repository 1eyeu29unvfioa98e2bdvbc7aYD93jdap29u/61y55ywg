package ru.pavlov.palestra.presentation.modules.authentication.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(AuthDiModule::class))
interface AuthComponent {
    fun getViewModel() : AuthVmContract.ViewModel
    fun getPresenter() : AuthVmContract.Presenter
}