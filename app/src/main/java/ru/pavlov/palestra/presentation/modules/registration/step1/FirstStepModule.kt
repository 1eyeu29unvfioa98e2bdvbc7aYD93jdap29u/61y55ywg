package ru.pavlov.palestra.presentation.modules.registration.step1

import android.support.v4.app.Fragment
import ru.pavlov.palestra.presentation.modules.registration.step1.view.FirstStepFragment

class FirstStepModule : FirstStepModuleContract {
    override fun createFragment(): Fragment = FirstStepFragment.newInstance()
}