package ru.pavlov.palestra.presentation.modules.registration.firststep.view

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
        val itemView: View = inflater.inflate(R.layout.fragment_registration_five_step, container, false)

        val binding: FragmentRegistrationFiveStepBinding = DataBindingUtil.bind(itemView)

        return itemView
    }
}