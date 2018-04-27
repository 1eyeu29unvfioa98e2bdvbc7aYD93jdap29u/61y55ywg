package ru.pavlov.palestra.presentation.modules.event.show.detailinfo.contract

import com.vershininds.mixture.router.MvpRouter

interface DetailEventRouterContract {
    interface Presenter : MvpRouter.Listener {
    }

    interface Router : MvpRouter<Presenter> {
    }
}