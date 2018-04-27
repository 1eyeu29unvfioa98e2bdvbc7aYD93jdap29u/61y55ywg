package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.presenter

import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.view.AndroidComponent
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract.DetailEventRouterContract
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract.DetailEventVmContract
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.viewmodel.DetailEventViewModel
import javax.inject.Inject

class DetailEventPresenter @Inject constructor(
        val router: DetailEventRouterContract.Router) : AbstractPresenter<DetailEventVmContract.ViewModel>(DetailEventViewModel()),
        DetailEventVmContract.Presenter, DetailEventRouterContract.Presenter {

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)

        router.apply {
//            setListener(this@CreateEventPresenter)
//            applyAction(this::showFirstStep)
        }

    }

    override fun detachView() {
        super.detachView()
    }

}