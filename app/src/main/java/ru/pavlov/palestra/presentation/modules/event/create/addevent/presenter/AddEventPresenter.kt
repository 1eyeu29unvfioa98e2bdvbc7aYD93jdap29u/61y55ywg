package ru.pavlov.palestra.presentation.modules.event.create.addevent.presenter

import palestra.viper.presenter.AbstractPresenter
import palestra.viper.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventInteractorContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventVmContract
import javax.inject.Inject

class AddEventPresenter() : AbstractPresenter<AddEventVmContract.ViewModel>(),
        AddEventVmContract.Presenter {

    private lateinit var interactor: AddEventInteractorContract.Interactor

    @Inject constructor(interactor: AddEventInteractorContract.Interactor) : this() {
        this.interactor = interactor
    }

    override fun attachView(viewModel: AddEventVmContract.ViewModel?, component: AndroidComponent?) {
        super.attachView(viewModel, component)
    }

    override fun detachView() {
        super.detachView()
    }
}