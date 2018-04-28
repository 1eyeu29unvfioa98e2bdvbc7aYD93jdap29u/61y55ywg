package ru.pavlov.palestra.presentation.modules.registration.parent.interactor

import com.vershininds.mixture.rx2interactor.AbstractInteractor
import ru.pavlov.palestra.domain.services.ServiceMaker
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationInteractorContract
import javax.inject.Inject

class RegistrationInteractor @Inject constructor(
        val serviceMaker: ServiceMaker) : AbstractInteractor<RegistrationInteractorContract.Presenter>(),
        RegistrationInteractorContract.Interactor {


}