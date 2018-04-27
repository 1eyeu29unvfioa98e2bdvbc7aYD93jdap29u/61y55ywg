package ru.pavlov.palestra.presentation.modules.event.show.detailinfo

import android.content.Context
import android.support.v4.app.Fragment
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.view.fragment.DetailEventFragment
import javax.inject.Inject

class DetailEventModule @Inject constructor() : DetailEventModuleContract {

    override fun createDetailEventFragment(context: Context): Fragment = DetailEventFragment.newInstance()
}