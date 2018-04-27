package ru.pavlov.palestra.presentation.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModule
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModuleContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.CreateEventHostModule
import ru.pavlov.palestra.presentation.modules.event.create.parent.CreateEventHostModuleContract
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.DetailEventModule
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.DetailEventModuleContract

@Module
class FeatureDeclaration {

    @PerPresentationScope
    @Provides
    fun providesCreateEventHostModule(createEventHostModule: CreateEventHostModule): CreateEventHostModuleContract = createEventHostModule

    @PerPresentationScope
    @Provides
    fun providesAddEventComponent(addEventModule: AddEventModule): AddEventModuleContract = addEventModule

    @PerPresentationScope
    @Provides
    fun providesDetailEventComponent(detailEventModule: DetailEventModule): DetailEventModuleContract = detailEventModule
}