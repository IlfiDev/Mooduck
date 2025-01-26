package org.ilfidev.mooduck

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ilfidev.mooduck.koin.di.initKoin
import org.ilfidev.mooduck.ui.App

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Mooduck",
        ) {
            App()
        }
    }
}