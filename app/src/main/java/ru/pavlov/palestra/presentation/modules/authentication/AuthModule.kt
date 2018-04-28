package ru.pavlov.palestra.presentation.modules.authentication

import android.content.Context
import ru.pavlov.palestra.presentation.modules.authentication.view.activity.AuthActivity
import javax.inject.Inject

class AuthModule @Inject constructor() : AuthModuleContract {
    override fun createIntent(context: Context) = AuthActivity.createIntent(context)
}