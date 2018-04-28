package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.presenter.WelcomePresenter
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.router.WelcomeRouter
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.viewmodel.WelcomeViewModel

@Module
class WelcomeDiModule {

    @PerFeatureScope
    @Provides
    fun providesPresenter(presenter: WelcomePresenter) : WelcomeVmContract.Presenter = presenter

    @PerFeatureScope
    @Provides
    fun providesRouter(router: WelcomeRouter) : WelcomeRouterContract.Router = router

    @PerFeatureScope
    @Provides
    fun providesViewModel() : WelcomeVmContract.ViewModel = WelcomeViewModel()
}