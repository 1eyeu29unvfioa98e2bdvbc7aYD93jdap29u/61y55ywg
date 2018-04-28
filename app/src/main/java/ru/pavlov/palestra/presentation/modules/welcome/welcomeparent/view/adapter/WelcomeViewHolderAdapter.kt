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
import java.util.*

class WelcomeViewHolderAdapter(private val context: Context) : PagerAdapter() {

    private var welcomeCards: List<WelcomeCard> = Collections.emptyList()

    fun setItems(welcomeCards: List<WelcomeCard>) {
        this.welcomeCards = welcomeCards
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as ConstraintLayout
    }

    override fun getCount(): Int {
        return welcomeCards.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater: LayoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
                inflater, R.layout.fragment_welcome, container, false)

        binding.txtTitleCard.text = welcomeCards[position].title
        binding.txtDescription.text = welcomeCards[position].description
        binding.imgWelcomeCard.setImageResource(welcomeCards[position].drawable)

        (container as ViewPager).addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        (container as ViewPager).removeView(obj as ConstraintLayout)
    }
}