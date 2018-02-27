package ru.pavlov.palestra.presentation.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModule
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModuleContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.di.AddEventComponent
import ru.pavlov.palestra.presentation.modules.event.create.addevent.di.AddEventDiModule
import ru.pavlov.palestra.presentation.modules.event.create.parent.CreateEventHostModule
import ru.pavlov.palestra.presentation.modules.event.create.parent.CreateEventHostModuleContract

@Module
class FeatureDeclaration {

    @PerPresentationScope
    @Provides
    fun providesCreateEventHostModule(createEventHostModule: CreateEventHostModule): CreateEventHostModuleContract = createEventHostModule

    @PerPresentationScope
    @Provides
    fun providesAddEventComponent(addEventModule: AddEventModule): AddEventModuleContract = addEventModule
}