package org.ilfidev.mooduck

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.ilfidev.mooduck.koin.di.initKoin
import org.ilfidev.mooduck.koin.di.sharedModule
import org.ilfidev.mooduck.ui.App
import org.koin.core.context.startKoin
import org.koin.dsl.module

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    ComposeViewport(document.body!!) {
        App()
    }
}