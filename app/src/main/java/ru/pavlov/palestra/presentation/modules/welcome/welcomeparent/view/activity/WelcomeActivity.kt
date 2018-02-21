package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityWelcomeBinding
import ru.pavlov.palestra.data.models.WelcomeCard
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.adapter.WelcomeViewHolderAdapter
import java.util.*

class WelcomeActivity : AppCompatActivity() {

    //fixme -- Kotlin ?
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        binding.viewPager.adapter =
                WelcomeViewHolderAdapter(this@WelcomeActivity, generate())
    }

    fun generate(): List<WelcomeCard> {
        return Arrays.asList(
                WelcomeCard(R.drawable.img_first_card, resources.getString(R.string.first_card_title), resources.getString(R.string.first_card_description)),
                WelcomeCard(R.drawable.img_second_card, resources.getString(R.string.second_card_title), resources.getString(R.string.second_card_description)),
                WelcomeCard(R.drawable.img_third_card, resources.getString(R.string.third_card_title), resources.getString(R.string.third_card_description)))
    }
}
