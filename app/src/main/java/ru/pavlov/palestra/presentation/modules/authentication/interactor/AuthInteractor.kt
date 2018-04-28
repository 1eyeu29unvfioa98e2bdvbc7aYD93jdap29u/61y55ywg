package ru.pavlov.palestra.presentation.modules.authentication.interactor

import com.vershininds.mixture.rx2interactor.AbstractInteractor
import ru.pavlov.palestra.domain.services.ServiceMaker
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthInteractorContract
import javax.inject.Inject

class AuthInteractor @Inject constructor(
        val serviceMaker: ServiceMaker) : AbstractInteractor<AuthInteractorContract.Presenter>(),
        AuthInteractorContract.Interactor {
}