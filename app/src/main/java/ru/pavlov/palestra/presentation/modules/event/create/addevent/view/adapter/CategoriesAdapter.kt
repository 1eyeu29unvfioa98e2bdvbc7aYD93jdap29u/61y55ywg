package ru.pavlov.palestra.presentation.modules.event.create.addevent.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import palestra.kotlin.databinding.ItemEventCategoryBinding
import ru.pavlov.palestra.data.models.EventCategories
import android.view.LayoutInflater
import palestra.kotlin.R


class CategoriesAdapter constructor(
        context: Context,
        resourceId: Int,
        private val eventsCategory: List<EventCategories>) :
        ArrayAdapter<EventCategories>(context, resourceId, eventsCategory) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootView = inflater.inflate(R.layout.item_event_category, parent, false)
            val binding: ItemEventCategoryBinding = DataBindingUtil.bind(rootView)

            binding.event = eventsCategory[position]

            return rootView
        }
        return (convertView)
    }
}