package ru.pavlov.palestra.presentation.modules.registration.parent.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.vershininds.mixture.view.AbstractActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityRegistrationBinding
import ru.pavlov.palestra.application.di.PalestraComponentProvider
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract
import ru.pavlov.palestra.presentation.modules.registration.parent.di.RegistrationComponent
import ru.pavlov.palestra.presentation.modules.registration.parent.di.RegistrationDiModule
import ru.pavlov.palestra.presentation.modules.registration.step1.view.FirstStepFragment

class RegistrationActivity : AbstractActivity<RegistrationVmContract.ViewModel, RegistrationVmContract.Presenter>() {

    private val TAG = RegistrationActivity::class.java.simpleName

    private lateinit var binding: ActivityRegistrationBinding

    private lateinit var diComponent: RegistrationComponent

    companion object {
        fun createIntent(context: Context) : Intent {
            return Intent(context, RegistrationActivity::class.java)
        }
    }

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
}