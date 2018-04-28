package ru.pavlov.palestra.presentation.di

import dagger.Component
import ru.pavlov.palestra.domain.di.BusinessComponent
import ru.pavlov.palestra.presentation.modules.authentication.di.AuthComponent
import ru.pavlov.palestra.presentation.modules.authentication.di.AuthDiModule
import ru.pavlov.palestra.presentation.modules.event.create.addevent.di.AddEventComponent
import ru.pavlov.palestra.presentation.modules.event.create.addevent.di.AddEventDiModule
import ru.pavlov.palestra.presentation.modules.event.create.parent.di.CreateEventHostComponent
import ru.pavlov.palestra.presentation.modules.event.create.parent.di.CreateEventHostDiModule
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.di.DetailEventComponent
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.di.DetailEventDiModule
import ru.pavlov.palestra.presentation.modules.registration.parent.di.RegistrationComponent
import ru.pavlov.palestra.presentation.modules.registration.parent.di.RegistrationDiModule
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di.WelcomeComponent
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di.WelcomeDiModule

@PerPresentationScope
@Component(modules = arrayOf(FeatureDeclaration::class), dependencies = arrayOf(BusinessComponent::class))
interface PresentationComponents {
    fun welcomeComponent(welcomeDiModule: WelcomeDiModule) : WelcomeComponent
    fun authComponent(authDiModule: AuthDiModule) : AuthComponent
    fun createEventHostComponent(createEventDiModule: CreateEventHostDiModule) : CreateEventHostComponent
    fun addEventComponent(addEventDiModule: AddEventDiModule) : AddEventComponent
    fun registrationComponent(registrationDiModule: RegistrationDiModule) : RegistrationComponent
    fun detailEventComponent(detailEventDiModule: DetailEventDiModule) : DetailEventComponent
}