package ru.pavlov.palestra.presentation.modules.registration.parent.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.di.PerFeatureScope
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationInteractorContract
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationRouterContract
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract
import ru.pavlov.palestra.presentation.modules.registration.parent.interactor.RegistrationInteractor
import ru.pavlov.palestra.presentation.modules.registration.parent.presenter.RegistrationPresenter
import ru.pavlov.palestra.presentation.modules.registration.parent.router.RegistrationRouter
import ru.pavlov.palestra.presentation.modules.registration.parent.viewmodel.RegistrationViewModel

@Module
class RegistrationDiModule {

    @PerFeatureScope
    @Provides
    fun providesPresenter(presenter: RegistrationPresenter) : RegistrationVmContract.Presenter = presenter

    @PerFeatureScope
    @Provides
    fun providesInteractor(interactor: RegistrationInteractor) : RegistrationInteractorContract.Interactor = interactor

    @PerFeatureScope
    @Provides
    fun providesRouter(router: RegistrationRouter) : RegistrationRouterContract.Router = router

    @PerFeatureScope
    @Provides
    fun providesViewModel() : RegistrationVmContract.ViewModel = RegistrationViewModel()
}