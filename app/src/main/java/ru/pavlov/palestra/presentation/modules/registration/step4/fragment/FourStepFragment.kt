package ru.pavlov.palestra.presentation.modules.registration.step4.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentRegistrationFourStepBinding

class FourStepFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationFourStepBinding

    fun newInstance(): Fragment {
        val fragment = FourStepFragment()

        val args = Bundle()
//        args.putParcelable(ARG_ORDER, order)
//        args.putParcelable(ARG_CURRENT_LOCATION, currentLocation)
        fragment.arguments = args

        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val itemView: View = inflater.inflate(R.layout.fragment_registration_four_step, container, false)

        val binding: FragmentRegistrationFourStepBinding = DataBindingUtil.bind(itemView)

        return itemView
    }
}