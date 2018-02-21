package ru.pavlov.palestra.presentation.modules.main.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityMainBinding
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventFirstStepFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setSupportActionBar(binding.in.toolbar)

//        goFragment(PersonFragment.newInstance())
//        goFragment(EventsFragment.newInstance())
        goFragment(AddEventFirstStepFragment.newInstance())
    }

    private fun goFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}