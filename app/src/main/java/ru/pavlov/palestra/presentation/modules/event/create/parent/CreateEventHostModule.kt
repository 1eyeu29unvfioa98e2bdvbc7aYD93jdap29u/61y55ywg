package ru.pavlov.palestra.presentation.modules.event.create.parent

import android.content.Context
import android.content.Intent
import ru.pavlov.palestra.presentation.modules.event.create.parent.view.activity.CreateEventActivity
import javax.inject.Inject

class CreateEventHostModule : CreateEventHostModuleContract {

    @Inject constructor()

    override fun createActivityIntent(context: Context): Intent = CreateEventActivity.createIntent(context)

}