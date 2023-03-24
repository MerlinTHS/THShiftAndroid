package de.ths.thshift.domain.impl.event

import de.ths.thshift.domain.api.event.Event
import de.ths.thshift.domain.api.event.EventRepository
import de.ths.thshift.domain.api.event.EventViewModel
import de.ths.thshift.domain.api.event.crud.CreateEventInfo
import de.ths.thshift.util.ioThread
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class SimpleEventViewModel(
    private val repository: EventRepository
) : EventViewModel() {
    private val _allEvents = MutableStateFlow(emptyList<Event>())
    override val allEvents = _allEvents.asSharedFlow()

    init {
        refresh()
    }

    override fun refresh() = ioThread {
        _allEvents.value = repository.getAllEvents()
    }

    override fun createEvent(info: CreateEventInfo) = ioThread {
        repository.createEvent(info)
    }
}