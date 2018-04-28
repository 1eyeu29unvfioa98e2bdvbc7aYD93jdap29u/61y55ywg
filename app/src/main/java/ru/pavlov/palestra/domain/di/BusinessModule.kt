package ru.pavlov.palestra.domain.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.pavlov.palestra.domain.services.ApiService
import ru.pavlov.palestra.domain.services.ServiceMaker
import ru.pavlov.palestra.domain.services.SharedPrefService

@Module
class BusinessModule {

    @Provides
    @PerBusinessScope
    fun provideServiceMaker(context: Context, sharedPrefService: SharedPrefService, apiService: ApiService)
            = ServiceMaker(context, sharedPrefService, apiService)

    @Provides
    @PerBusinessScope
    fun provideSharedPreffService(context: Context) = SharedPrefService(context)

    @Provides
    @PerBusinessScope
    fun provideApiService(context: Context) = ApiService(context)
}
