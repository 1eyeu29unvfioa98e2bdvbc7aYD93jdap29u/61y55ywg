package ru.pavlov.palestra.presentation.modules.registration.firststep.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentRegistrationThirdStepBinding

class ThirdStepFragment : Fragment() {

    private lateinit var biding: FragmentRegistrationThirdStepBinding

    fun newInstance(): Fragment {
        val fragment = ThirdStepFragment()

        val args = Bundle()
//        args.putParcelable(ARG_ORDER, order)
//        args.putParcelable(ARG_CURRENT_LOCATION, currentLocation)
        fragment.arguments = args

        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val itemView: View = inflater.inflate(R.layout.fragment_registration_third_step, container, false)

        val binding: FragmentRegistrationThirdStepBinding = DataBindingUtil.bind(itemView)

        return itemView
    }
}