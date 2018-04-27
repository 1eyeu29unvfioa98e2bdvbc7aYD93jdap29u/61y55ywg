package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.di

import dagger.Subcomponent
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract.DetailEventVmContract

@PerFeatureScope
@Subcomponent(modules = arrayOf(DetailEventDiModule::class))
interface DetailEventComponent {
    fun getViewModel() : DetailEventVmContract.ViewModel
    fun getPresenter() : DetailEventVmContract.Presenter
}