package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent

import android.content.Context
import android.content.Intent

interface WelcomeModuleContract {
    fun createIntent(context: Context) : Intent
}