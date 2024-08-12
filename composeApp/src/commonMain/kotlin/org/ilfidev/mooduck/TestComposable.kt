package org.ilfidev.mooduck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MoodBoardCard() {
    Card {
        Row() {
//            Row()
            Text("Aboba")

        }
    }
}

@Preview
@Composable
fun MoodBoardCardHeader() {
    Row(modifier = Modifier.background(Color.Green)) {
        Text("Анимее бабы")
        Card(
        ) {
            Text("888 Лаек")
        }
    }
}
