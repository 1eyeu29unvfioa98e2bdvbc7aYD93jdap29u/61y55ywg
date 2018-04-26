package ru.pavlov.palestra.presentation.modules.registration.parent.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityRegistrationBinding
import ru.pavlov.palestra.presentation.modules.registration.step1.view.FirstStepFragment

class RegistrationActivity : AppCompatActivity() {

    private val TAG = RegistrationActivity::class.java.simpleName
    private val FIRST_STEP = TAG + "_first_step"

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        val fragmentManager = supportFragmentManager
        val fragment: Fragment? = fragmentManager.findFragmentByTag(FIRST_STEP)

        if (fragment == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FirstStepFragment().newInstance(), FIRST_STEP)
                    .commit()
        }
    }
}