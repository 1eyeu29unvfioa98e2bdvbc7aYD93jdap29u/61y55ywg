package ru.pavlov.palestra.presentation.modules.registration.step1.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentRegistrationFirstStepBinding

class FirstStepFragment : Fragment() {

    private lateinit var biding: FragmentRegistrationFirstStepBinding

    fun newInstance(): Fragment {
        val fragment = FirstStepFragment()

        val args = Bundle()
//        args.putParcelable(ARG_ORDER, order)
//        args.putParcelable(ARG_CURRENT_LOCATION, currentLocation)
        fragment.setArguments(args)

        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val itemView: View = inflater.inflate(R.layout.fragment_registration_first_step, container, false)

        val binding: FragmentRegistrationFirstStepBinding = DataBindingUtil.bind(itemView)

        return itemView
    }
}