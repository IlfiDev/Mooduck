package org.ilfidev.mooduck

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout


import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun RememberWindowInfo(): WindowInfo {
    val width = getScreenWidth()
    val height = getScreenHeight()
    return WindowInfo(
        screenWidthInfo = when {
            width < 600.dp -> WindowInfo.WindowType.Compact
            width < 840.dp -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Wide
        },

        screenHeightInfo = when {
            height < 480.dp -> WindowInfo.WindowType.Compact
            height < 900.dp -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Wide
                           },
        screenWidth = width,
        screenHeight = height
    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp,
) {
    sealed class WindowType {
        object Compact : WindowType()
        object Medium : WindowType()
        object Wide : WindowType()
    }
}

@Composable
expect fun getScreenWidth(): Dp

@Composable
expect fun getScreenHeight(): Dp