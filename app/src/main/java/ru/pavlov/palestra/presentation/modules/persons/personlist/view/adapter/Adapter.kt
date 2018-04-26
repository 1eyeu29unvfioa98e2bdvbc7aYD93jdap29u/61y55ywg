package ru.pavlov.palestra.presentation.modules.persons.personlist.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.ItemPersonListBinding
import ru.pavlov.palestra.data.models.presentation.Person

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var persons: MutableList<Person> = java.util.ArrayList()

    public fun setItems(persons: ArrayList<Person>) {
        this.persons.clear()
        this.persons.addAll(persons)

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(persons[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemPersonListBinding>(
                LayoutInflater.from(parent.context), R.layout.item_person_list, parent, false)

        return ViewHolder(binding)
    }


    override fun getItemCount() = persons.size

    class ViewHolder constructor(val binding: ItemPersonListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) = with(itemView) {
            val text = "${person.name} ${person.secondName}"
            binding.txtPersonName.text = text
        }
    }
}