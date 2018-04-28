package ru.pavlov.palestra.presentation.modules.authentication

import android.content.Context
import android.content.Intent

interface AuthModuleContract {
    fun createIntent(context: Context) : Intent
}