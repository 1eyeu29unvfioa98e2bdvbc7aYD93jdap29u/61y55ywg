package ru.pavlov.palestra.domain.services

import android.content.Context

class ServiceMaker(val context: Context,
                   val sharedPrefService: SharedPrefService,
                   val apiService: ApiService)