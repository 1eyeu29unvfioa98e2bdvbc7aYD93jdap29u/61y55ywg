package ru.pavlov.palestra.presentation.modules.event.create.parent.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(CreateEventHostDiModule::class))
interface CreateEventHostComponent {
    fun getViewModel() : CreateEventVmContract.ViewModel
    fun getPresenter() : CreateEventVmContract.Presenter
}