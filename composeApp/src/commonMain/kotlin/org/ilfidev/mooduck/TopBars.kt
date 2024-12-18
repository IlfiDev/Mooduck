package org.ilfidev.mooduck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainActivityTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).background(Color(0xFF818181))
            .padding(top = 1.dp, bottom = 1.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "MOOOOOOOODUCK",
            fontSize = 50.sp,
            style = TextStyle(color = Color(0xFF2200FF), fontWeight = FontWeight.ExtraBold)
        )
        Switch(false, onCheckedChange = null)
        SearchBarWithButtons(hint = "pososi",cornerShape = RoundedCornerShape(100.dp))
    }
}