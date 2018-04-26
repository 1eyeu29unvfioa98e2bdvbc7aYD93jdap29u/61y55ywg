package ru.pavlov.palestra.presentation.modules.registration.step2.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentRegistrationSecondStepBinding
import ru.pavlov.palestra.presentation.modules.registration.step2.view.adapter.CityAdapter

class SecondStepFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationSecondStepBinding

    fun newInstance(): Fragment {
        val fragment = SecondStepFragment()

        val args = Bundle()
//        args.putParcelable(ARG_ORDER, order)
//        args.putParcelable(ARG_CURRENT_LOCATION, currentLocation)
        fragment.setArguments(args)

        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistrationSecondStepBinding>(
                inflater, R.layout.fragment_registration_second_step, container, false)

        binding.cityList.layoutManager = LinearLayoutManager(context)

        val cityAdapter = CityAdapter(context)
        cityAdapter.setCities(generate())
        binding.cityList.adapter = cityAdapter

        return binding.root
    }

    private fun generate(): ArrayList<String> {
        val cities = ArrayList<String>()
        (1..8).mapTo(cities) { "City# " + it.toString() }
        return cities
    }
}