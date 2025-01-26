package org.ilfidev.mooduck.koin.di


import io.ktor.client.HttpClient
import org.ilfidev.mooduck.DbClient
import org.ilfidev.mooduck.networking.HttpClientConfig
import org.ilfidev.mooduck.networking.HttpClientConfigImpl
import org.ilfidev.mooduck.viewmodel.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DbClient)
    singleOf(::HttpClientConfigImpl).bind<HttpClientConfig>()
}