package ru.pavlov.palestra.presentation.modules.registration.parent.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import com.vershininds.mixture.view.AbstractActivity
import palestra.kotlin.BR
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityRegistrationBinding
import ru.pavlov.palestra.application.di.PalestraComponentProvider
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract
import ru.pavlov.palestra.presentation.modules.registration.parent.di.RegistrationComponent
import ru.pavlov.palestra.presentation.modules.registration.parent.di.RegistrationDiModule

class RegistrationActivity : AbstractActivity<RegistrationVmContract.ViewModel, RegistrationVmContract.Presenter>() {

    companion object {
        val TAG = RegistrationActivity::class.java.simpleName

        fun createIntent(context: Context) : Intent {
            return Intent(context, RegistrationActivity::class.java)
        }
    }

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var diComponent: RegistrationComponent

    override fun injectDi() {
        diComponent = PalestraComponentProvider.getPalestraComponent(application)
                .presentationComponents()
                .registrationComponent(RegistrationDiModule())
    }

    override fun createPresenter(): RegistrationVmContract.Presenter = diComponent.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        binding.includeBtnNext?.apply {
            title = getString(R.string.next)
        }
    }

    override fun onStart() {
        viewModel.addOnPropertyChangedCallback(vmObserver)
        super.onStart()
    }

    override fun onStop() {
        viewModel.removeOnPropertyChangedCallback(vmObserver)
        super.onStop()
    }

    private val vmObserver = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable, i: Int) {
            val vm = viewModel
            when (i) {
                BR.registrationStep -> {
                }
            }
        }
    }
}