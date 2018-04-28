package ru.pavlov.palestra.presentation.modules.authentication.router

import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthRouterContract
import javax.inject.Inject

class AuthRouter @Inject constructor() : AbstractRouter<AuthRouterContract.Presenter>(),
        AuthRouterContract.Router {
}