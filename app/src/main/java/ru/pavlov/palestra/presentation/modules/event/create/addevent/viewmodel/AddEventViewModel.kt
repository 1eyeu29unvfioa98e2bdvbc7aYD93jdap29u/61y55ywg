package ru.pavlov.palestra.presentation.modules.event.create.addevent.viewmodel

import com.vershininds.mixture.viewmodel.AbstractViewModel
import org.parceler.Parcel
import ru.pavlov.palestra.presentation.modules.event.create.addevent.contract.AddEventVmContract

@Parcel
class AddEventViewModel : AbstractViewModel(),
        AddEventVmContract.ViewModel {
}