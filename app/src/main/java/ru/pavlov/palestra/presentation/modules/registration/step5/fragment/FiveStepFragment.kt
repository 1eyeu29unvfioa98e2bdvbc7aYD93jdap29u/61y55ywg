package ru.pavlov.palestra.presentation.modules.registration.step5.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentRegistrationFiveStepBinding

class FiveStepFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationFiveStepBinding

    fun newInstance(): Fragment {
        val fragment = FiveStepFragment()

        val args = Bundle()
//        args.putParcelable(ARG_ORDER, order)
//        args.putParcelable(ARG_CURRENT_LOCATION, currentLocation)
        fragment.arguments = args

        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistrationFiveStepBinding>(
                inflater, R.layout.fragment_registration_five_step, container, false)

        return binding.root
    }
}