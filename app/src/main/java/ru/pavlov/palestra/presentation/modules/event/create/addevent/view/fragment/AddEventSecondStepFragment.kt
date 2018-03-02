package ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.transition.TransitionInflater
import android.support.v4.app.Fragment
import android.support.v4.app.SharedElementCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentAddEventSecondBinding
import ru.pavlov.palestra.data.models.EventCategories
import ru.pavlov.palestra.data.models.EventsType
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.adapter.CategoriesAdapter
import java.util.*

class AddEventSecondStepFragment : Fragment() {

    private lateinit var binding: FragmentAddEventSecondBinding
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
        val view: View = inflater.inflate(R.layout.fragment_add_event_second, container, false)
        binding = DataBindingUtil.bind(view)



        val transition = TransitionInflater.from(context)
                .inflateTransition(R.transition.txt_shared_element_transition)
        sharedElementEnterTransition = transition

        setEnterSharedElementCallback(
                object : SharedElementCallback() {
                    override fun onMapSharedElements(
                            names: List<String>, sharedElements: MutableMap<String, View>) {
                        // Маппим имя первого общего элемента к дочерней ImageView.
                        sharedElements[names[0]] = binding.txtHelp
                    }
                })



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