package ru.pavlov.palestra.presentation.modules.event.create.addevent

import android.support.v4.app.Fragment

interface AddEventModuleContract {
    fun createAddEventFirstStepFragment(): Fragment
    fun createAddEventSecondStepFragment(): Fragment
    fun createAddEventThirdStepFragment(): Fragment
}