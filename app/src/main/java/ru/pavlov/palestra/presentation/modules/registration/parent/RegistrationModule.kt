package ru.pavlov.palestra.presentation.modules.registration.parent

import android.content.Context
import android.content.Intent
import ru.pavlov.palestra.presentation.modules.registration.parent.view.RegistrationActivity
import javax.inject.Inject

class RegistrationModule @Inject constructor() : RegistrationModuleContract {
    override fun createIntent(context: Context) = RegistrationActivity.createIntent(context)
}