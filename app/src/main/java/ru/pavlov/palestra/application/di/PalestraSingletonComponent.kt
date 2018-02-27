package ru.pavlov.palestra.application.di

import android.content.Context
import dagger.Component
import ru.pavlov.palestra.domain.di.BusinessComponent
import ru.pavlov.palestra.presentation.di.PresentationComponents

@PerApp
@Component(dependencies = arrayOf(BusinessComponent::class),
        modules = arrayOf(PalestraSingletonModule::class))
interface PalestraSingletonComponent {
    fun context(): Context
    fun businessComponent(): BusinessComponent
    fun presentationComponents(): PresentationComponents
}