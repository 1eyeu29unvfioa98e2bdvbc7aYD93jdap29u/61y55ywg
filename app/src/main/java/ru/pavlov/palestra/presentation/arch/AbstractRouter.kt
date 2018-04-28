package ru.pavlov.palestra.presentation.arch

import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.view.View
import com.vershininds.mixture.router.AbstractRouter
import com.vershininds.mixture.router.MvpRouter
import com.vershininds.mixture.view.AndroidComponent

abstract class AbstractRouter<L : MvpRouter.Listener> : AbstractRouter<L>() {

    protected fun displayFragmentAdd(androidComponent: AndroidComponent, fragment: Fragment, tag: String, fragmentContainerId: Int) {
        val fragmentManager = androidComponent.supportFragmentManager
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction()
                    .add(fragmentContainerId, fragment, tag)
                    .addToBackStack(null)
                    .commit()
        }
    }

    protected fun displayFragmentReplace(androidComponent: AndroidComponent, fragment: Fragment, tag: String, fragmentContainerId: Int) {
        val fragmentManager = androidComponent.supportFragmentManager
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction()
                    .replace(fragmentContainerId, fragment, tag)
                    .commit()
        }
    }

    protected fun displayActivityWithSharedView(androidComponent: AndroidComponent, intent: Intent, sharedView: View, sharedViewName: String) {
        val activity = androidComponent.activity
        val activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity, sharedView, sharedViewName).toBundle()

        intent.apply {
            activity.startActivity(this, activityOptionsCompat)
        }
    }
}