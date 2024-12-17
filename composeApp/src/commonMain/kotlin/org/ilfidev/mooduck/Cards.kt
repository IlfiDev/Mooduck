package org.ilfidev.mooduck

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun MainCard(data: MainCardData) {
    val likes = data.likesCount
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.wrapContentWidth().shadow(0.dp, shape = RectangleShape).clickable {},
        backgroundColor = Color(0xFFd8d8d8)
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            MainCardHeader(data.title, likes)
            MainCardContent(data.description, data.imageUrl)
        }
    }
}

@Preview
@Composable
fun MainCardHeader(title: String, likesCount: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().height(height = 36.dp).background(Color.Blue)
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WrappedTextWithMaxWidth(title)
        Text(
            modifier = Modifier.widthIn(100.dp, 300.dp),
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Row(modifier = Modifier.height(26.dp).background(Color(0xFFd8d8d8)).padding(horizontal = 10.dp)) {
            Text(
                "$likesCount лайков",
                style = TextStyle(fontSize = 16.sp)
            )
        }
    }
}

@Composable
fun MainCardContent(description: String, imageUrl: String?) {
    Column(modifier = Modifier.fillMaxSize().padding(vertical = 23.dp, horizontal = 15.dp)) {

        AsyncImage(
            model = imageUrl,
            contentDescription = "",
            modifier = Modifier
                .width(300.dp).height(300.dp)
                .border(
                    border = BorderStroke(width = 1.dp, Color.Black)
                ),
            contentScale = ContentScale.Fit
        )

        Text(description)

        Row() {
            Text("Author")
            Text("000.200")
        }
    }
}


@Composable
fun WrappedTextWithMaxWidth(text: String) {
    val maxWidth = 300.dp
//    var textState by remember { mutableStateOf(text) }

    Box(modifier = Modifier.width(maxWidth)) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 5
        )
    }
}