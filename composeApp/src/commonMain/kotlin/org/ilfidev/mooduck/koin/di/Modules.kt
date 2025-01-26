package org.ilfidev.mooduck.koin.di

import org.ilfidev.mooduck.BoardsDataRepository
import org.ilfidev.mooduck.BoardsRepositoryBackendImpl
import org.ilfidev.mooduck.BoardsRepositoryDbImpl
import org.ilfidev.mooduck.viewmodel.RegistrationViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    singleOf(::BoardsRepositoryDbImpl).bind<BoardsDataRepository>()
    viewModelOf(::RegistrationViewModel)
}