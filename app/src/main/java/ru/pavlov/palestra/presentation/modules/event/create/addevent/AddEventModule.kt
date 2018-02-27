package ru.pavlov.palestra.presentation.modules.event.create.addevent

import android.support.v4.app.Fragment
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventFirstStepFragment
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventSecondStepFragment
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventThirdStepFragment
import javax.inject.Inject

class AddEventModule @Inject constructor() : AddEventModuleContract {
    override fun createAddEventFirstStepFragment(): Fragment = AddEventFirstStepFragment.newInstance()
    override fun createAddEventSecondStepFragment(): Fragment = AddEventSecondStepFragment.newInstance()
    override fun createAddEventThirdStepFragment(): Fragment = AddEventThirdStepFragment.newInstance()
}