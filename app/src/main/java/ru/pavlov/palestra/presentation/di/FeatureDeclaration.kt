package ru.pavlov.palestra.presentation.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.modules.authentication.AuthModule
import ru.pavlov.palestra.presentation.modules.authentication.AuthModuleContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModule
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModuleContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.CreateEventHostModule
import ru.pavlov.palestra.presentation.modules.event.create.parent.CreateEventHostModuleContract
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.DetailEventModule
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.DetailEventModuleContract
import ru.pavlov.palestra.presentation.modules.registration.parent.RegistrationModule
import ru.pavlov.palestra.presentation.modules.registration.parent.RegistrationModuleContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.WelcomeModule
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.WelcomeModuleContract

@Module
class FeatureDeclaration {

    @PerPresentationScope
    @Provides
    fun providesWelcomeComponent(welcomeModule: WelcomeModule): WelcomeModuleContract = welcomeModule

    @PerPresentationScope
    @Provides
    fun providesAuthComponent(authModule: AuthModule): AuthModuleContract = authModule

    @PerPresentationScope
    @Provides
    fun providesCreateEventHostModule(createEventHostModule: CreateEventHostModule): CreateEventHostModuleContract = createEventHostModule

    @PerPresentationScope
    @Provides
    fun providesAddEventComponent(addEventModule: AddEventModule): AddEventModuleContract = addEventModule

    @PerPresentationScope
    @Provides
    fun providesRegistrationComponent(registrationModule: RegistrationModule): RegistrationModuleContract = registrationModule

    @PerPresentationScope
    @Provides
    fun providesDetailEventComponent(detailEventModule: DetailEventModule): DetailEventModuleContract = detailEventModule
}