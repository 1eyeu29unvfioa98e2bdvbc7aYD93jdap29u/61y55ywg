package ru.pavlov.palestra.presentation.di

import dagger.Component
import ru.pavlov.palestra.domain.di.BusinessComponent
import ru.pavlov.palestra.presentation.modules.event.create.addevent.di.AddEventComponent
import ru.pavlov.palestra.presentation.modules.event.create.addevent.di.AddEventDiModule
import ru.pavlov.palestra.presentation.modules.event.create.parent.di.CreateEventHostComponent
import ru.pavlov.palestra.presentation.modules.event.create.parent.di.CreateEventHostDiModule

@PerPresentationScope
@Component(modules = arrayOf(FeatureDeclaration::class), dependencies = arrayOf(BusinessComponent::class))
interface PresentationComponents {
    fun createEventHostComponent(createEventDiModule: CreateEventHostDiModule) : CreateEventHostComponent
    fun addEventComponent(addEventDiModule: AddEventDiModule) : AddEventComponent
}