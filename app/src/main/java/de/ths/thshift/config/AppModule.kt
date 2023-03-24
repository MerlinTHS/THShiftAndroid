package de.ths.thshift.config

import de.ths.thshift.domain.api.event.EventRepository
import de.ths.thshift.domain.api.event.EventViewModel
import de.ths.thshift.domain.impl.event.KtorEventRepository
import de.ths.thshift.domain.impl.event.SimpleEventViewModel
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val homeUrl = "http://192.168.178.92:1234"

private val jsonConfig = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
}

private val client = HttpClient {
    install(ContentNegotiation) {
        json(jsonConfig)
    }
}

val AppModule = module {
    single<EventRepository> { KtorEventRepository(homeUrl, client) }
    viewModel<EventViewModel> { SimpleEventViewModel(get()) }
}