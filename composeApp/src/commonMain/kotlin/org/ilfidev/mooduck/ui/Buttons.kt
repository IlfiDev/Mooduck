package org.ilfidev.mooduck.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.adamglin.composeshadow.dropShadow
import com.adamglin.composeshadow.innerShadow
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit) {
    Button(onClick = onClick,
           shape = RectangleShape,
           modifier = Modifier
               .size(142.dp, 50.dp)
               .padding(4.dp)
               .innerShadow(
                   shape = RectangleShape,
                   color = Color.White.copy(1f),
                   offsetX = -1.dp,
                   offsetY = 1.dp,
                   blur = 0.dp,
                   spread = 4.dp,
               ).dropShadow(
                   shape = RectangleShape,
                   color = Color.Black.copy(1f),
                   offsetX = -4.dp,
                   offsetY = 4.dp,
                   blur = 0.dp,
                   spread = 0.dp,
               ),
           colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD9D9D9), disabledBackgroundColor = Color(0x838383))
    ){
        Text(text)
    }
}

@Composable
@Preview
fun DefaultButtonPreview() {
    DefaultButton("TestText", {})
}