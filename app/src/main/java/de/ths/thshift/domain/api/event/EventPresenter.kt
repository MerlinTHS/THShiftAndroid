package de.ths.thshift.domain.api.event

import de.ths.thshift.domain.api.event.crud.CreateEventInfo
import kotlinx.coroutines.flow.SharedFlow

/**
 * Provides observable [Event] collection and non-suspended CRUD methods.
 */
interface EventPresenter {
    val allEvents: SharedFlow<List<Event>>

    fun createEvent(info: CreateEventInfo)
}