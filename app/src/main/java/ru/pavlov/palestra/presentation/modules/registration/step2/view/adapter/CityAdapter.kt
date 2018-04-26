package ru.pavlov.palestra.presentation.modules.registration.step2.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.ItemCityListBinding

class CityAdapter(val context: Context?) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    var cityList = ArrayList<String>()

    public fun setCities(cityList: ArrayList<String>) {
        this.cityList.clear()
        this.cityList.addAll(cityList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val backgroundCityItem: Int =
                if (cityList.size - 1 == position) {
                    //last element
                    R.drawable.bg_register_edit_bottom
                } else {
                    R.color.authBackgroundShapeEdit
                }

        holder.itemView.setBackgroundResource(backgroundCityItem)
        holder.binding.txtCityName.text = cityList[position]
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_city_list, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemCityListBinding = DataBindingUtil.bind(itemView)!!
    }
}