package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentEventDetailInfoBinding

class DetailEventFragment : Fragment() {

    private lateinit var binding: FragmentEventDetailInfoBinding

    companion object {
        fun newInstance(): DetailEventFragment {
            val args = Bundle()
//        args.putSerializable(ARG_CAUGHT, caught)

            val fragment = DetailEventFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_detail_info, container, false)


        return binding.root
    }
}