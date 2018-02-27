package ru.pavlov.palestra.application

import android.app.Application
import ru.pavlov.palestra.application.di.DaggerPalestraSingletonComponent
import ru.pavlov.palestra.application.di.PalestraSingletonComponent
import ru.pavlov.palestra.application.di.PalestraSingletonComponentHolder
import ru.pavlov.palestra.application.di.PalestraSingletonModule
import ru.pavlov.palestra.domain.di.BusinessComponent
import ru.pavlov.palestra.domain.di.DaggerBusinessComponent
import ru.pavlov.palestra.presentation.di.DaggerPresentationComponents
import ru.pavlov.palestra.presentation.di.PresentationComponents

class Application : Application(),
        PalestraSingletonComponentHolder {

    companion object {
        lateinit var businessComponent: BusinessComponent
        lateinit var presentationComponents: PresentationComponents

    }

    private lateinit var palestraSingletonComponent: PalestraSingletonComponent

    override fun onCreate() {
        super.onCreate()

        businessComponent = DaggerBusinessComponent.builder().with(this).build()
        presentationComponents = DaggerPresentationComponents.builder().businessComponent(businessComponent).build()

        palestraSingletonComponent = DaggerPalestraSingletonComponent.builder()
                .businessComponent(businessComponent)
                .palestraSingletonModule(PalestraSingletonModule())
                .build()
    }

    override fun getPalestraSingletonComponent(): PalestraSingletonComponent {
        return palestraSingletonComponent
    }

//    @NonNull
//    public final T init(@NonNull CommonSingletonComponent commonSingletonComponent) {
//        T component = createComponent(commonSingletonComponent);
//        initSingletons(component);
//        return component;
//    }
}