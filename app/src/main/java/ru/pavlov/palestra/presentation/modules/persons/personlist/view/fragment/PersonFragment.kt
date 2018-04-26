package ru.pavlov.palestra.presentation.modules.persons.personlist.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentPersonListBinding
import ru.pavlov.palestra.data.models.presentation.Person
import ru.pavlov.palestra.presentation.modules.persons.personlist.view.adapter.Adapter

class PersonFragment : Fragment() {

    lateinit var binding: FragmentPersonListBinding
    lateinit var personAdapter: Adapter

    companion object {
        fun newInstance(): PersonFragment {
            val args = Bundle()
//        args.putSerializable(ARG_CAUGHT, caught)

            val fragment = PersonFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        personPersonAdapterDelegate = PersonAdapterDelegate()
//        personPersonAdapterDelegate.setItems(generatePersons())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_list, container, false)

        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.listItems.layoutManager = linearLayoutManager
        binding.listItems.setHasFixedSize(true)

//        binding.listItems.adapter = personPersonAdapterDelegate

        return view
    }

    fun generatePersons(): ArrayList<Person> {
        val person: ArrayList<Person> = java.util.ArrayList()
        return (1..10).mapTo(person) { Person("Name #$it", "Second #$it", "Url #$it") }
    }
}