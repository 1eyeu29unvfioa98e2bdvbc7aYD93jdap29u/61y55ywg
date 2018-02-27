package ru.pavlov.palestra.presentation.modules.main.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityMainBinding
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventFirstStepFragment
import ru.pavlov.palestra.presentation.modules.event.show.eventlist.view.fragment.EventsFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setSupportActionBar(binding.in.toolbar)

//        goFragment(PersonFragment.newInstance())
        goFragment(EventsFragment.newInstance())
//        goFragment(AddEventFirstStepFragment.newInstance())

        binding.includeBottomNavigation?.bottomNavigation?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                }
                R.id.events_on_cards -> {
                }
                R.id.new_event -> {
                }
                R.id.events_on_map -> {
                }
                R.id.my_profile -> {
                }
            }

            true
        }
    }

    private fun goFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}