package ru.pavlov.palestra.presentation.modules.event.show.eventlist.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentEventsListBinding
import ru.pavlov.palestra.data.models.presentation.Event
import ru.pavlov.palestra.data.models.presentation.EventsType
import ru.pavlov.palestra.presentation.modules.event.show.eventlist.view.adapter.EventsAdapter
import java.util.*

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsListBinding
    private lateinit var eventsAdapter: EventsAdapter

    companion object {
        fun newInstance(): EventsFragment {
            val args = Bundle()
//        args.putSerializable(ARG_CAUGHT, caught)

            val fragment = EventsFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        eventsAdapter = EventsAdapter()
        eventsAdapter.setItems(generatedEvents())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_list, container, false)

//        setActivityToolbar()

        binding.btnByDate.requestFocus()

        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.listEvents.layoutManager = linearLayoutManager
        binding.listEvents.setHasFixedSize(false)
        binding.listEvents.adapter = eventsAdapter


        return binding.root
    }
//
//    private fun setActivityToolbar() = (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

    private fun generatedEvents() = (1..10).map { generateEvent() }

    private fun generateEvent(): Event {
        val rand = Random()
        return Event(
                when (rand.nextInt(3)) {
                    1 -> "Баскетбольный вечерок! #${rand.nextInt()}"
                    2 -> "Читаем Гарри Поттера в центре, жду всех!! #${rand.nextInt()}"
                    else -> "Публичное выступление Декана на выставке по изобразительному исскуству!"
                },
                "Description #${rand.nextInt()}",
                "${rand.nextInt(18)}+",
                "${rand.nextInt(23)}:00 - ${rand.nextInt(23)}:00",
                "Kostroma #${rand.nextInt()}",
                when (rand.nextInt(3)) {
                    1 -> EventsType.FUN
                    2 -> EventsType.MIDDLE_FUN
                    else -> {
                        EventsType.NO_FUN
                    }
                })
    }
}