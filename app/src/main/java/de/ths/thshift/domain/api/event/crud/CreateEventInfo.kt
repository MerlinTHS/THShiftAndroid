package de.ths.thshift.domain.api.event.crud

import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class CreateEventInfo(
    val from: LocalDateTime,
    val to: LocalDateTime,
)