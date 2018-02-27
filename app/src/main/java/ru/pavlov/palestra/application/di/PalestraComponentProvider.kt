package ru.pavlov.palestra.application.di

import android.app.Application
import android.content.Context
import android.support.annotation.NonNull

class PalestraComponentProvider {
    companion object {

        @NonNull
        fun getPalestraComponent(@NonNull context: Context): PalestraSingletonComponent {
            val application: Application = context.applicationContext as Application
            return (application as PalestraSingletonComponentHolder).getPalestraSingletonComponent()

        }
    }
}