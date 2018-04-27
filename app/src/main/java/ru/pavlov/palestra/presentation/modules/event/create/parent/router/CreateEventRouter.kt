package ru.pavlov.palestra.presentation.modules.event.create.parent.router

import com.vershininds.mixture.view.AndroidComponent
import palestra.kotlin.R
import ru.pavlov.palestra.presentation.arch.AbstractRouter
import ru.pavlov.palestra.presentation.modules.event.create.addevent.AddEventModuleContract
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventFirstStepFragment
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventSecondStepFragment
import ru.pavlov.palestra.presentation.modules.event.create.addevent.view.fragment.AddEventThirdStepFragment
import ru.pavlov.palestra.presentation.modules.event.create.parent.contract.CreateEventRouterContract
import javax.inject.Inject

class CreateEventRouter() : AbstractRouter<CreateEventRouterContract.Presenter>(),
        CreateEventRouterContract.Router {

    private val fragmentContainerId = R.id.fragment_container
    lateinit var addEventModuleContract: AddEventModuleContract

    @Inject constructor(addEventModuleContract: AddEventModuleContract) : this() {
        this.addEventModuleContract = addEventModuleContract
    }

    override fun showFirstStep(androidComponent: AndroidComponent) {
        addEventModuleContract.createAddEventFirstStepFragment().apply {
            displayFragmentAdd(androidComponent, this, AddEventFirstStepFragment.TAG, fragmentContainerId)
        }
    }

    override fun showSecondStep(androidComponent: AndroidComponent) {
        addEventModuleContract.createAddEventSecondStepFragment().apply {
            displayFragmentAdd(androidComponent, this, AddEventSecondStepFragment.TAG, fragmentContainerId)
        }
    }

    override fun showThirdStep(androidComponent: AndroidComponent) {
        addEventModuleContract.createAddEventThirdStepFragment().apply {
            displayFragmentAdd(androidComponent, this, AddEventThirdStepFragment.TAG, fragmentContainerId)
        }
    }

    override fun goBack(androidComponent: AndroidComponent) {
        androidComponent.supportFragmentManager.apply {
            when {
                popBackStackImmediate() -> {
                    when {
                        findFragmentByTag(AddEventFirstStepFragment.TAG) != null -> listener.firstStepDisplayed()
                        findFragmentByTag(AddEventSecondStepFragment.TAG) != null -> listener.secondStepDisplayed()
                        findFragmentByTag(AddEventThirdStepFragment.TAG) != null -> listener.thirdStepDisplayed()
                    }
                }
                else -> {
                    performFinish(androidComponent)
                }
            }
        }
    }

    override fun performFinish(androidComponent: AndroidComponent) {
        androidComponent.activity.apply {
            if (this != null && !this.isFinishing) {
                this.finish()
            }
        }
    }
}