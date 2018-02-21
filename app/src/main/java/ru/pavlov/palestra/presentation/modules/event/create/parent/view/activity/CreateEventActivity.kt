package ru.pavlov.palestra.presentation.modules.event.create.parent.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityAddEventParentBinding
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventFirstStepFragment

class CreateEventActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddEventParentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_event_parent)

        goFragment(AddEventFirstStepFragment.newInstance())
    }

    private fun goFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}