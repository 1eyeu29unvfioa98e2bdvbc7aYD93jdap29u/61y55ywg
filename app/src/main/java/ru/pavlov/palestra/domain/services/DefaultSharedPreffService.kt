package ru.pavlov.palestra.domain.services

import android.content.Context

class DefaultSharedPreffService(val context: Context) {

    companion object {
        const val DEFAULT_REPOSITORY_KEY = "Default_repository"

        const val IS_FIRST_LAUNCH_APP_KEY = "First_launch_app"
    }

    fun setFirstLaunchApp(isFirstLaunch: Boolean) {
        getDefaultSharedPrefferences()
                .edit()
                .putBoolean(IS_FIRST_LAUNCH_APP_KEY, isFirstLaunch)
    }

    fun isFirstLaunchApp(isFirstStart: Boolean) {

    }

    private fun getDefaultSharedPrefferences() = context.getSharedPreferences(DEFAULT_REPOSITORY_KEY, Context.MODE_PRIVATE)
}