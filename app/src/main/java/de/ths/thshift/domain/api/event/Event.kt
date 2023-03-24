package de.ths.thshift.domain.api.event

import de.ths.thshift.domain.Model
import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Event(
    override val id: ULong,
    override val updatedAt: LocalDateTime,
    override val createdAt: LocalDateTime,
    val from: LocalDateTime,
    val to: LocalDateTime,
) : Model