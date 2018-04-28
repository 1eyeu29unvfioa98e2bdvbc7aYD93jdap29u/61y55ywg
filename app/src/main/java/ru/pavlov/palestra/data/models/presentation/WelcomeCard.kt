package ru.pavlov.palestra.data.models.presentation

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class WelcomeCard @ParcelConstructor constructor(
        val drawable: Int,
        val title: String,
        val description: String)