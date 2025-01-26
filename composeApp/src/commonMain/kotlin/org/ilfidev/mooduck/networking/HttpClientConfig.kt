package org.ilfidev.mooduck.networking

import io.ktor.client.HttpClient

interface HttpClientConfig {
    fun getHttpClient(): HttpClient
}

expect class HttpClientConfigImpl() : HttpClientConfig