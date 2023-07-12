package de.ths.thshift.config

import androidx.compose.ui.tooling.data.EmptyGroup.parameters
import de.ths.thshift.domain.api.event.EventRepository
import de.ths.thshift.domain.api.event.EventViewModel
import de.ths.thshift.domain.impl.event.KtorEventRepository
import de.ths.thshift.domain.impl.event.SimpleEventViewModel
import io.ktor.client.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val homeUrl = "http://192.168.178.92:1234"

private val jsonConfig = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
}

fun test() = runBlocking {
    val authorizationUrlQuery = parameters {
        append("client_id", System.getenv("GOOGLE_CLIENT_ID"))
        append("scope", "https://www.googleapis.com/auth/userinfo.profile")
        append("response_type", "code")
        append("redirect_uri", "http://127.0.0.1:8080")
        append("access_type", "offline")
    }.formUrlEncode()
}

private val client = HttpClient {
    install(ContentNegotiation) {
        json(jsonConfig)
    }
    install(Auth) {
        bearer {
            loadTokens {

                BearerTokens("", "")
            }
        }
    }
}

val AppModule = module {
    single<EventRepository> { KtorEventRepository(homeUrl, client) }
    viewModel<EventViewModel> { SimpleEventViewModel(get()) }
}

