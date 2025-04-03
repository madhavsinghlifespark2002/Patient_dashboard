package org.example.project

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface Platform {
    val name: String
}
expect fun openWebView(url: String)
expect fun getPlatform(): Platform
expect fun getHttpClient(): HttpClient
//val httpClient: HttpClient by lazy {
//    getHttpClient()
//}
val httpClient = HttpClient(CIO) {
    install(HttpTimeout) {
        requestTimeoutMillis = 15_000
        connectTimeoutMillis = 15_000
        socketTimeoutMillis = 15_000
    }
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
}
