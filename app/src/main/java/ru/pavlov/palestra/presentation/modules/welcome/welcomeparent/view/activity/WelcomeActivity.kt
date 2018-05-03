package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import com.vershininds.mixture.view.AbstractActivity
import palestra.kotlin.BR
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityWelcomeBinding
import ru.pavlov.palestra.application.di.PalestraComponentProvider
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di.WelcomeComponent
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.di.WelcomeDiModule
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.view.adapter.WelcomeViewHolderAdapter

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
        diComponent = PalestraComponentProvider.getPalestraComponent(application)
                .presentationComponents()
                .welcomeComponent(WelcomeDiModule())
    }

    override fun createPresenter(): WelcomeVmContract.Presenter = diComponent.getPresenter()

    override fun onStart() {
        viewModel.addOnPropertyChangedCallback(vmObserver)
        super.onStart()
    }

    override fun onStop() {
        viewModel.removeOnPropertyChangedCallback(vmObserver)
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        binding.viewPager.apply {
            slider.adapter = WelcomeViewHolderAdapter(this@WelcomeActivity)
            binding.sliderIndicator.setupWithViewPager(slider)
        }

        binding.includeBtnEnter?.apply {
            title = getString(R.string.enter)

            btnContainer.setOnClickListener {
                presenter.enterAppClick(binding.includeBtnEnter!!.btnContainer)
            }
        }
    }

    private val vmObserver = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable, i: Int) {
            val vm = viewModel
            when (i) {
                BR.welcomeCards -> {
                    binding.viewPager.apply {
                        (slider.adapter as WelcomeViewHolderAdapter).setItems(vm.welcomeCards)
                        binding.sliderIndicator.setupWithViewPager(slider)
                    }
                }
            }
        }
    }
}
