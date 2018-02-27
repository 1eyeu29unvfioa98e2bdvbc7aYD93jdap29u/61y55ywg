package ru.pavlov.palestra.presentation.modules.event.create.parent.view.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityAddEventParentBinding
import palestra.viper.view.AbstractActivity
import ru.pavlov.palestra.application.di.PalestraComponentProvider
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.di.CreateEventHostComponent
import ru.pavlov.palestra.presentation.modules.event.create.parent.di.CreateEventHostDiModule

class CreateEventActivity : AbstractActivity<CreateEventVmContract.ViewModel, CreateEventVmContract.Presenter>() {

    private lateinit var diComponent: CreateEventHostComponent

    private lateinit var binding: ActivityAddEventParentBinding

    companion object {
        fun createIntent(context: Context): Intent =
                Intent(context, CreateEventActivity::class.java).apply {
                    //todo putExtra()
                }
    }

    override fun injectDi() {
        //todo startInit

        diComponent = PalestraComponentProvider.getPalestraComponent(application)
                .presentationComponents()
                .createEventHostComponent(CreateEventHostDiModule())
    }

    override fun createPresenter(): CreateEventVmContract.Presenter = diComponent.getPresenter()

    override fun createViewModel(): CreateEventVmContract.ViewModel = diComponent.getViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_event_parent)

        binding.includeToolbar?.btnNext?.setOnClickListener { view ->
            presenter.nextStepClick()
        }
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}