package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vershininds.mixture.view.AbstractActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityWelcomeBinding
import ru.pavlov.palestra.data.models.presentation.WelcomeCard
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di.WelcomeComponent
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.adapter.WelcomeViewHolderAdapter
import java.util.*

class WelcomeActivity : AbstractActivity<WelcomeVmContract.ViewModel, WelcomeVmContract.Presenter>() {

    companion object {
        val TAG = WelcomeActivity::class.java

        fun createIntent(context: Context): Intent {
            return Intent(context, WelcomeActivity::class.java)
        }
    }

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var diComponent: WelcomeComponent

    override fun injectDi() {

    }

    override fun createPresenter(): WelcomeVmContract.Presenter = diComponent.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        binding.viewPager.apply {
            slider.adapter = WelcomeViewHolderAdapter(this@WelcomeActivity, generate())
            binding.sliderIndicator.setupWithViewPager(slider)
        }
    }

    fun generate(): List<WelcomeCard> {
        return Arrays.asList(
                WelcomeCard(R.drawable.img_first_card, resources.getString(R.string.first_card_title), resources.getString(R.string.first_card_description)),
                WelcomeCard(R.drawable.img_second_card, resources.getString(R.string.second_card_title), resources.getString(R.string.second_card_description)),
                WelcomeCard(R.drawable.img_third_card, resources.getString(R.string.third_card_title), resources.getString(R.string.third_card_description)))
    }
}
