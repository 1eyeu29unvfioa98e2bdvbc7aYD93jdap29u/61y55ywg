package ru.pavlov.palestra.presentation.modules.event.create.addevent.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventInteractorContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventVmContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.viewmodel.AddEventViewModel
import javax.inject.Inject

class AddEventPresenter() : AbstractPresenter<AddEventVmContract.ViewModel>(AddEventViewModel()),
        AddEventVmContract.Presenter {

    private lateinit var interactor: AddEventInteractorContract.Interactor

    @Inject constructor(interactor: AddEventInteractorContract.Interactor) : this() {
        this.interactor = interactor
    }

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)
    }

    override fun detachView() {
        super.detachView()
    }
}