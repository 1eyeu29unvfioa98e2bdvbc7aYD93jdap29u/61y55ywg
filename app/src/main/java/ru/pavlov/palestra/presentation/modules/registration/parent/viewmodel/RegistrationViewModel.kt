package ru.pavlov.palestra.presentation.modules.registration.parent.viewmodel

import com.vershininds.mixture.viewmodel.AbstractViewModel
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import palestra.kotlin.BR
import ru.pavlov.palestra.presentation.modules.registration.parent.contract.RegistrationVmContract

@Parcel
class RegistrationViewModel : AbstractViewModel, RegistrationVmContract.ViewModel {

    @JvmField
    var _registrationStep: RegistrationVmContract.RegistrationSteps

    constructor() : super() {
        this._registrationStep = RegistrationVmContract.RegistrationSteps.STEP1
        notifyChange()
    }

    @ParcelConstructor
    constructor(id: String, _registrationStep: RegistrationVmContract.RegistrationSteps) : super(id) {
        this._registrationStep = _registrationStep

        notifyChange()
    }


    override var registrationStep: RegistrationVmContract.RegistrationSteps
        get() = _registrationStep
        set(value) {
            _registrationStep = value
            notifyPropertyChanged(BR.registrationStep)
        }
}