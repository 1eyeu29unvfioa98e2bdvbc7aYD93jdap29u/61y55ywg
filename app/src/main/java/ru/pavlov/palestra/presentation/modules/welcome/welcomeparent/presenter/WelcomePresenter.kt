package ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.presenter

import android.content.res.Resources
import android.view.View
import com.vershininds.mixture.presenter.AbstractPresenter
import com.vershininds.mixture.presenter.MvpPresenter
import com.vershininds.mixture.view.AndroidComponent
import palestra.kotlin.R
import ru.pavlov.palestra.data.models.presentation.WelcomeCard
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeRouterContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.contract.WelcomeVmContract
import ru.pavlov.palestra.presentation.modules.welcome.welcomeparent.viewmodel.WelcomeViewModel
import java.util.*
import javax.inject.Inject

class WelcomePresenter @Inject constructor(
        val router: WelcomeRouterContract.Router) : AbstractPresenter<WelcomeVmContract.ViewModel>(WelcomeViewModel()),
        WelcomeVmContract.Presenter, WelcomeRouterContract.Presenter {

    override fun attachView(component: AndroidComponent?) {
        super.attachView(component)

        router.apply {
            setListener(this@WelcomePresenter)
        }

        generateWelcomeCards(component!!.activity.resources)
    }

    override fun detachView() {
        router.apply {
            setListener(null)
        }

        super.detachView()
    }

    override fun enterAppClick(sharedView: View) {
        applyAction({ router.showAuthScreen(androidComponent, sharedView) })
    }

    private fun generateWelcomeCards(resources: Resources) {
        viewModel.welcomeCards = Arrays.asList(
                WelcomeCard(R.drawable.img_first_card, resources.getString(R.string.first_card_title), resources.getString(R.string.first_card_description)),
                WelcomeCard(R.drawable.img_second_card, resources.getString(R.string.second_card_title), resources.getString(R.string.second_card_description)),
                WelcomeCard(R.drawable.img_third_card, resources.getString(R.string.third_card_title), resources.getString(R.string.third_card_description)))
    }
}