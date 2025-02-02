package org.ilfidev.mooduck.util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.util.decodeBase64Bytes
import org.jetbrains.skia.Image

actual fun decodeBase64ToImageBitmap(base64: String): ImageBitmap? {
    return Image.makeFromEncoded(base64.decodeBase64Bytes()).toComposeImageBitmap()
}
