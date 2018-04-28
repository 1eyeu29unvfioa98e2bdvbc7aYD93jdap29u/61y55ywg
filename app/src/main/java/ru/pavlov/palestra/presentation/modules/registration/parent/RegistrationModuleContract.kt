package ru.pavlov.palestra.presentation.modules.registration.parent

import android.content.Context
import android.content.Intent

interface RegistrationModuleContract {
    fun createIntent(context: Context): Intent
}