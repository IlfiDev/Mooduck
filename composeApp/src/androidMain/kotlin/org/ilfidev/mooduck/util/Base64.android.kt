package org.ilfidev.mooduck.util

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.coroutines.CoroutineStart

actual fun decodeBase64ToImageBitmap(base64: String): ImageBitmap? {
    return try {
        val imageBytes = Base64.decode(base64, 1)
        val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        bitmap.asImageBitmap()
    } catch (e: Exception) {
        null
    }
}