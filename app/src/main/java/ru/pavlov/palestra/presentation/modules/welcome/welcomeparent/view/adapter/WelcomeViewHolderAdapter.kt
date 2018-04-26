package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import palestra.kotlin.R
import palestra.kotlin.databinding.FragmentWelcomeBinding
import ru.pavlov.palestra.data.models.presentation.WelcomeCard

class WelcomeViewHolderAdapter(
        val context: Context,
        val welcomeCards: List<WelcomeCard>) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as ConstraintLayout
    }

    override fun getCount(): Int {
        return welcomeCards.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater: LayoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView: View = inflater.inflate(R.layout.fragment_welcome, container, false)

        val binding: FragmentWelcomeBinding = DataBindingUtil.bind(itemView)

        binding.txtTitleCard.text = welcomeCards[position].title
        binding.txtDescription.text = welcomeCards[position].description
        binding.imgWelcomeCard.setImageResource(welcomeCards[position].drawable)

        (container as ViewPager).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        (container as ViewPager).removeView(obj as ConstraintLayout)
    }
}