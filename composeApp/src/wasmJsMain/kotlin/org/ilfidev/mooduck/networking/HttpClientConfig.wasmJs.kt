package org.ilfidev.mooduck.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BasicAuthCredentials
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual class HttpClientConfigImpl actual constructor() : HttpClientConfig {
    override fun getHttpClient(): HttpClient {

        return HttpClient   {
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
                basic {
                    credentials {
                        BasicAuthCredentials("aa", "aa")
                    }
                }
            }
        }

    }
}