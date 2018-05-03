package ru.pavlov.palestra.presentation.modules.registration.parent.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.view.AndroidComponent
import org.greenrobot.eventbus.EventBus
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationInteractorContract
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationRouterContract
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract
import ru.pavlov.palestra.presentation.modules.registration.parent.viewmodel.RegistrationViewModel
import javax.inject.Inject

import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract.RegistrationSteps

class RegistrationPresenter @Inject constructor(
        val interactor: RegistrationInteractorContract.Interactor,
        val router: RegistrationRouterContract.Router) : AbstractPresenter<RegistrationVmContract.ViewModel>(RegistrationViewModel()),
        RegistrationInteractorContract.Presenter {

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)

        //todo: setVmState (INITIAL ...)

        interactor.setListener(this@RegistrationPresenter)

        router.apply {
            setListener(this@RegistrationPresenter)
            showFirstRegisterScreen()
        }


        EventBus.getDefault().apply {
            if (!isRegistered(this@RegistrationPresenter)) {
                register(this@RegistrationPresenter)
            }
        }
    }

    override fun detachView() {
        interactor.setListener(null)
        router.setListener(null)

        EventBus.getDefault().unregister(this@RegistrationPresenter)

        super.detachView()
    }

    private fun showFirstRegisterScreen() {
        viewModel.registrationStep = RegistrationSteps.STEP1
        //todo: Show first step
    }

    private fun showSecondRegisterScreen() {
        viewModel.registrationStep = RegistrationSteps.STEP2
    }

    private fun showThirdRegisterScreen() {
        viewModel.registrationStep = RegistrationSteps.STEP3
    }

    private fun showFourRegisterScreen() {
        viewModel.registrationStep = RegistrationSteps.STEP4
    }

    private fun showFiveRegisterScreen() {
        viewModel.registrationStep = RegistrationSteps.STEP5
    }

}