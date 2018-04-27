package ru.pavlov.palestra.presentation.modules.event.create.parent.viewmodel

import com.vershininds.mixture.viewmodel.AbstractViewModel
import org.parceler.Parcel
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract

@Parcel(Parcel.Serialization.BEAN)
class CreateEventViewModel() : AbstractViewModel(), CreateEventVmContract.ViewModel {

}