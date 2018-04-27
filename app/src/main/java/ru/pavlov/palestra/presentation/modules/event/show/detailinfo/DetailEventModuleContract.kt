package ru.pavlov.palestra.presentation.modules.event.show.detailinfo

import android.content.Context
import android.support.v4.app.Fragment

interface DetailEventModuleContract {
    fun createDetailEventFragment(context: Context) : Fragment
}