package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.router

import palestra.viper.router.AbstractRouter
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract

class WelcomeRouter : AbstractRouter<WelcomeRouterContract.Presenter>(), WelcomeRouterContract.Router {

    override fun goAuthScreen() {

    }
}