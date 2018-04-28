package ru.pavlov.palestra.presentation.modules.authentication.view.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.vershininds.mixture.view.AbstractActivity
import palestra.kotlin.R
import palestra.kotlin.databinding.ActivityAuthenticationBinding
import ru.pavlov.palestra.application.di.PalestraComponentProvider
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthVmContract
import ru.pavlov.palestra.presentation.modules.authentication.di.AuthComponent
import ru.pavlov.palestra.presentation.modules.authentication.di.AuthDiModule

class AuthActivity : AbstractActivity<AuthVmContract.ViewModel, AuthVmContract.Presenter>() {

    companion object {
        val TAG = AuthActivity::class.java.simpleName

        fun createIntent(context: Context): Intent {
            return Intent(context, AuthActivity::class.java)
        }
    }

    private lateinit var binding: ActivityAuthenticationBinding
    private lateinit var diComponent: AuthComponent

    override fun injectDi() {
        diComponent = PalestraComponentProvider.getPalestraComponent(application)
                .presentationComponents()
                .authComponent(AuthDiModule())
    }

    override fun createPresenter(): AuthVmContract.Presenter = diComponent.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_authentication)

        binding.includeBtnEnter?.apply {
            title = getString(R.string.enter)
        }

        binding.txtGotoRegister.apply {
            setOnClickListener {
                presenter.onRegisterClick(binding.includeBtnEnter!!.btnContainer)
            }
        }
    }
}