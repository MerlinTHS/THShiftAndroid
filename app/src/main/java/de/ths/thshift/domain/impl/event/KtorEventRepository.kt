package de.ths.thshift.domain.impl.event

import de.ths.thshift.domain.api.event.Event
import de.ths.thshift.domain.api.event.EventRepository
import de.ths.thshift.domain.api.event.crud.CreateEventInfo
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * [EventRepository] which uses only one data source to retrieve events.
 */
class KtorEventRepository(
    private val homeUrl: String,
    private val client: HttpClient
) : EventRepository {

    override suspend fun createEvent(info: CreateEventInfo) {
        client.post("$homeUrl/events/create") {
            contentType(ContentType.Application.Json)
            setBody(info)
        }
    }

    override suspend fun getAllEvents(): List<Event> {
        val events: Array<Event> = client.get("$homeUrl/events")
            .body()

        return events.toList()
    }
}