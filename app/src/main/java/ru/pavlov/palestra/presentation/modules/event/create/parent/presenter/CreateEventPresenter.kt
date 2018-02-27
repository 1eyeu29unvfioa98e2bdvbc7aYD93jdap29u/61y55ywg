package ru.pavlov.palestra.presentation.modules.event.create.parent.presenter

import palestra.viper.presenter.AbstractPresenter
import palestra.viper.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventRouterContract
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract
import javax.inject.Inject

class CreateEventPresenter() : AbstractPresenter<CreateEventVmContract.ViewModel>(),
        CreateEventVmContract.Presenter, CreateEventRouterContract.Presenter {

    private lateinit var router: CreateEventRouterContract.Router

    @Inject constructor(router: CreateEventRouterContract.Router) : this() {
        this.router = router

    }

    override fun attachView(viewModel: CreateEventVmContract.ViewModel?, component: AndroidComponent?) {
        super.attachView(viewModel, component)

        router.apply {
            setListener(this@CreateEventPresenter)
            showFirstStep(androidComponent)
        }

    }

    override fun detachView() {
        super.detachView()
    }

    override fun nextStepClick() {
        router.showSecondStep(androidComponent)
    }

    override fun onBackPressed() {
        router.goBack(androidComponent)
    }


    override fun secondStepDisplayed() {

    }

    override fun thirdStepDisplayed() {

    }

    override fun firstStepDisplayed() {

    }
}