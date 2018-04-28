package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(WelcomeDiModule::class))
interface WelcomeComponent {
    fun getViewModel() : WelcomeVmContract.ViewModel
    fun getPresenter() : WelcomeVmContract.Presenter
}
