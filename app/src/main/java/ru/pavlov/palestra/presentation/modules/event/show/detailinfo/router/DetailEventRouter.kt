package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.router

import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract.DetailEventRouterContract
import javax.inject.Inject

class DetailEventRouter @Inject constructor() : AbstractRouter<DetailEventRouterContract.Presenter>(),
        DetailEventRouterContract.Router {

}