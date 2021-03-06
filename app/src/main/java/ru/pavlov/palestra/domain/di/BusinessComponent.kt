package ru.pavlov.palestra.domain.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.pavlov.palestra.domain.services.ServiceMaker

@PerBusinessScope
@Component(modules = arrayOf(BusinessModule::class))
interface BusinessComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun with(context: Context): Builder

        fun build(): BusinessComponent
    }

    fun context(): Context

    fun serviceMaker() : ServiceMaker
}