package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.viewmodel

import com.vershininds.mixture.viewmodel.AbstractViewModel
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import palestra.kotlin.BR
import ru.pavlov.palestra.data.models.presentation.WelcomeCard
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract
import java.util.*

@Parcel
class WelcomeViewModel : AbstractViewModel, WelcomeVmContract.ViewModel {

    protected var _welcomeCards: List<WelcomeCard>

    constructor() : super() {
        _welcomeCards = Collections.emptyList()
        notifyChange()
    }

    @ParcelConstructor
    constructor(id: String, _welcomeCards: List<WelcomeCard>) : super(id) {
        this._welcomeCards = _welcomeCards
        notifyChange()
    }

    override var welcomeCards: List<WelcomeCard>
        get() = _welcomeCards
        set(value) {
            _welcomeCards = value
            notifyPropertyChanged(BR.welcomeCards)
        }

}