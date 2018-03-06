package ru.pavlov.palestra.application.di

import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.domain.di.BusinessComponent
import ru.pavlov.palestra.presentation.di.DaggerPresentationComponents
import ru.pavlov.palestra.presentation.di.FeatureDeclaration
import ru.pavlov.palestra.presentation.di.PresentationComponents

@Module
class PalestraSingletonModule {

    @PerApp
    @Provides
    fun providePresentation(businessComponent: BusinessComponent) : PresentationComponents =
            DaggerPresentationComponents.builder()
                    .businessComponent(businessComponent)
                    .featureDeclaration(FeatureDeclaration()).build()
}