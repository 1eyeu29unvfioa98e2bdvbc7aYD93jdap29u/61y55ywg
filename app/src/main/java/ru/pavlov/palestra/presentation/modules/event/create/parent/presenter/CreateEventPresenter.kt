package ru.pavlov.palestra.presentation.modules.event.create.parent.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventRouterContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.viewmodel.CreateEventViewModel
import javax.inject.Inject

class CreateEventPresenter @Inject constructor(
        val router: CreateEventRouterContract.Router) : AbstractPresenter<CreateEventVmContract.ViewModel>(CreateEventViewModel()),
        CreateEventVmContract.Presenter, CreateEventRouterContract.Presenter {

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)

        router.apply {
            setListener(this@CreateEventPresenter)
            applyAction(this::showFirstStep)
        }

    }

    override fun detachView() {
        super.detachView()
    }

    override fun nextStepClick() {
        applyAction(router::showSecondStep)
    }

    override fun onBackPressed() {
        applyAction(router::goBack)
    }


    override fun secondStepDisplayed() {

    }

    override fun thirdStepDisplayed() {

    }

    override fun firstStepDisplayed() {

    }
}