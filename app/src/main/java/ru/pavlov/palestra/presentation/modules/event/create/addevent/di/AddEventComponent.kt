package ru.pavlov.palestra.presentation.modules.event.create.addevent.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(AddEventDiModule::class))
interface AddEventComponent {
    fun getViewModel() : AddEventVmContract.ViewModel
    fun getPresenter() : AddEventVmContract.Presenter
}