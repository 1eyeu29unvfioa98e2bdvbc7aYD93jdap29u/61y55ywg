package ru.pavlov.palestra.presentation.modules.event.create.parent

import android.content.Context
import android.content.Intent

interface CreateEventHostModuleContract {
    fun createActivityIntent(context: Context) : Intent
}