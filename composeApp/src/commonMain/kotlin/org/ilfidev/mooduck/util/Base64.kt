package org.ilfidev.mooduck.util

import androidx.compose.ui.graphics.ImageBitmap

expect fun decodeBase64ToImageBitmap(base64: String): ImageBitmap?