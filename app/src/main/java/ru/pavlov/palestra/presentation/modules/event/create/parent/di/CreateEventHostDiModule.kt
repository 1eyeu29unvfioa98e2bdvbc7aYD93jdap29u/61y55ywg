package ru.pavlov.palestra.presentation.modules.event.create.parent.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventRouterContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.presenter.CreateEventPresenter
import ru.pavlov.palestra.presentation.modules.event.create.parent.router.CreateEventRouter
import ru.pavlov.palestra.presentation.modules.event.create.parent.viewmodel.CreateEventViewModel

@Module
class CreateEventHostDiModule {

    //todo Need constructor

    @PerFeatureScope
    @Provides
    fun providesPresenter(presenter: CreateEventPresenter): CreateEventVmContract.Presenter = presenter

    @PerFeatureScope
    @Provides
    fun providesRouter(router: CreateEventRouter): CreateEventRouterContract.Router = router

    @PerFeatureScope
    @Provides
    fun providesViewModel(): CreateEventVmContract.ViewModel = CreateEventViewModel()
}