package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract.DetailEventRouterContract
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract.DetailEventVmContract
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.presenter.DetailEventPresenter
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.router.DetailEventRouter
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.viewmodel.DetailEventViewModel

@Module
class DetailEventDiModule {

    @PerFeatureScope
    @Provides
    fun providesPresenter(presenter: DetailEventPresenter): DetailEventVmContract.Presenter = presenter

    @PerFeatureScope
    @Provides
    fun providesRouter(router: DetailEventRouter): DetailEventRouterContract.Router = router

    @PerFeatureScope
    @Provides
    fun providesViewModel(): DetailEventVmContract.ViewModel = DetailEventViewModel()
}