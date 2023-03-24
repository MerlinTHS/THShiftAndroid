package de.ths.thshift.domain.api.event

import de.ths.thshift.domain.api.event.crud.CreateEventInfo

interface EventRepository {
    suspend fun getAllEvents(): List<Event>

    suspend fun createEvent(info: CreateEventInfo)
}