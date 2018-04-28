package ru.pavlov.palestra.presentation.modules.authentication.viewmodel

import com.vershininds.mixture.viewmodel.AbstractViewModel
import org.parceler.Parcel
import ru.pavlov.palestra.presentation.modules.authentication.contract.AuthVmContract

@Parcel
class AuthViewModel : AbstractViewModel(), AuthVmContract.ViewModel {
}