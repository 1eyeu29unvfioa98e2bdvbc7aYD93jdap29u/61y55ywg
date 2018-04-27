package ru.pavlov.palestra.presentation.modules.event.create.parent.contract

import android.support.annotation.NonNull
import com.vershininds.mixture.router.MvpRouter
import com.vershininds.mixture.view.AndroidComponent

interface CreateEventRouterContract {
    interface Presenter : MvpRouter.Listener {
        fun firstStepDisplayed()
        fun secondStepDisplayed()
        fun thirdStepDisplayed()
    }

    interface Router : MvpRouter<Presenter> {
        fun showFirstStep(@NonNull androidComponent: AndroidComponent)
        fun showSecondStep(@NonNull androidComponent: AndroidComponent)
        fun showThirdStep(@NonNull androidComponent: AndroidComponent)
        fun goBack(@NonNull androidComponent: AndroidComponent)
        fun performFinish(@NonNull androidComponent: AndroidComponent)
    }
}