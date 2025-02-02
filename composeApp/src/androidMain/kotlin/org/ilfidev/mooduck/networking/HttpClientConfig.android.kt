package org.ilfidev.mooduck.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


actual class HttpClientConfigImpl actual constructor() : HttpClientConfig {
    override fun getHttpClient(): HttpClient {

        return HttpClient(OkHttp) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true

                    }
                )
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ2b3ZhIiwiZXhwIjoxNzM5MDU2NDEzfQ.YWvMK9npY4AtqqAGtnAUDZekJjouQya9UlRoAJBpoik", "aaa")
                    }
                }
            }
        }

    }
}