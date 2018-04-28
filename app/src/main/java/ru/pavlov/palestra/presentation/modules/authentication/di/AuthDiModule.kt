package ru.pavlov.palestra.presentation.modules.authentication.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthInteractorContract
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthRouterContract
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthVmContract
import ru.pavlov.palestra.presentation.modules.authentication.interactor.AuthInteractor
import ru.pavlov.palestra.presentation.modules.authentication.presenter.AuthPresenter
import ru.pavlov.palestra.presentation.modules.authentication.router.AuthRouter
import ru.pavlov.palestra.presentation.modules.authentication.viewmodel.AuthViewModel

@Module
class AuthDiModule {

    @PerFeatureScope
    @Provides
    fun providesPresenter(presenter: AuthPresenter) : AuthVmContract.Presenter = presenter

    @PerFeatureScope
    @Provides
    fun providesInteractor(interactor: AuthInteractor) : AuthInteractorContract.Interactor = interactor

    @PerFeatureScope
    @Provides
    fun providesRouter(router: AuthRouter) : AuthRouterContract.Router = router

    @PerFeatureScope
    @Provides
    fun providesViewModel() : AuthVmContract.ViewModel = AuthViewModel()
}