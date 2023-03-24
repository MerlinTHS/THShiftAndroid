package de.ths.thshift.domain

import java.time.LocalDateTime

interface Model {
    val id: ULong
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime
}