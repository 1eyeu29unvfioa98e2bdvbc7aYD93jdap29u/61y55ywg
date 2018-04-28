package ru.pavlov.palestra.presentation.modules.authentication

import android.content.Context
import ru.pavlov.palestra.presentation.modules.authentication.view.activity.AuthActivity

class AuthModule : AuthModuleContract {
    override fun createIntent(context: Context) = AuthActivity.createIntent(context)
}