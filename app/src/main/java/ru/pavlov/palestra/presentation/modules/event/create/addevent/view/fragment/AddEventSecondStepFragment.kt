package ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentAddEventBinding
import ru.pavlov.palestra.data.models.EventCategories
import ru.pavlov.palestra.data.models.EventsType
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.adapter.CategoriesAdapter
import java.util.*

class AddEventSecondStepFragment : Fragment() {

    private lateinit var binding: FragmentAddEventBinding
    private lateinit var gridAdapter: CategoriesAdapter
    companion object {
        val TAG = AddEventSecondStepFragment::class.java.simpleName

        fun newInstance(): AddEventSecondStepFragment {
            val args = Bundle()
//        args.putSerializable(ARG_CAUGHT, caught)

            val fragment = AddEventSecondStepFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_registration_four_step, container, false)
//        binding = DataBindingUtil.bind(view)

        val list = generatedEvents()

//        gridAdapter = CategoriesAdapter(context!!, R.layout.item_event_category, list)
//
//        binding.eventCategories.adapter = gridAdapter

        return view
    }

    private fun generatedEvents() = (1..10).map { generateEvent() }

    private fun generateEvent(): EventCategories {
        val rand = Random()
        return EventCategories(
                "Категория #${rand.nextInt(10)}",
                when (rand.nextInt(2)) {
                    0 -> EventsType.FUN
                    1 -> EventsType.MIDDLE_FUN
                    else -> EventsType.NO_FUN
                },
                rand.nextBoolean()
        )
    }
}