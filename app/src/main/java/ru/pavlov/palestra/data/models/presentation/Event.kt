package ru.pavlov.palestra.data.models.presentation

//todo необходимо доделывать
data class Event(
        val eventName: String,
        val eventDescription: String,
        val eventOld: String,
        val eventTime: String,
        val eventCoordinate: String,
        val eventType: EventsType)