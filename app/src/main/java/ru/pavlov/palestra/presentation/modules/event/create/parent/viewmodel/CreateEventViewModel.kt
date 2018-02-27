package ru.pavlov.palestra.presentation.modules.event.create.parent.viewmodel

import org.parceler.Parcel
import palestra.viper.viewmodel.AbstractViewModel
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventVmContract

@Parcel(Parcel.Serialization.BEAN)
class CreateEventViewModel() : AbstractViewModel(), CreateEventVmContract.ViewModel {

}