package ru.pavlov.palestra.presentation.modules.event.create.addevent.interactor

import com.vershininds.mixture.rx2interactor.AbstractInteractor
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventInteractorContract
import javax.inject.Inject

class AddEventInteractor @Inject constructor() : AbstractInteractor<AddEventInteractorContract.Presenter>(),
        AddEventInteractorContract.Interactor {
}