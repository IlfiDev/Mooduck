package org.ilfidev.mooduck.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainActivityTopBar(
    headerMainText: String? = "",
    switch: @Composable () -> Unit,
    searchField: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).background(Color(0xFF818181))
            .padding(top = 1.dp, bottom = 1.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "MOOOOOOOODUCK",
            fontSize = 50.sp,
            style = TextStyle(color = Color(0xFF2200FF), fontWeight = FontWeight.ExtraBold)
        )
        switch()
        searchField()
        
    }
}