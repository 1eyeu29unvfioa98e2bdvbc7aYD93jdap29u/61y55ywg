package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent

import android.content.Context
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.activity.WelcomeActivity
import javax.inject.Inject

class WelcomeModule @Inject constructor() : WelcomeModuleContract {
    override fun createIntent(context: Context) = WelcomeActivity.createIntent(context)
}