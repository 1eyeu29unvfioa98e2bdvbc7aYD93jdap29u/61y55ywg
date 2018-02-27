package ru.pavlov.palestra.presentation.modules.event.create.addevent.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventInteractorContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventVmContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.interactor.AddEventInteractor
import ru.pavlov.palestra.presentation.modules.event.create.addevent.presenter.AddEventPresenter
import ru.pavlov.palestra.presentation.modules.event.create.addevent.viewmodel.AddEventViewModel

@Module
class AddEventDiModule {

    @PerFeatureScope
    @Provides
    fun providesPresenter(presenter: AddEventPresenter): AddEventVmContract.Presenter = presenter

    @PerFeatureScope
    @Provides
    fun providesInteractor(interactor: AddEventInteractor): AddEventInteractorContract.Interactor = interactor

    @PerFeatureScope
    @Provides
    fun providesViewModel(): AddEventVmContract.ViewModel = AddEventViewModel()
}