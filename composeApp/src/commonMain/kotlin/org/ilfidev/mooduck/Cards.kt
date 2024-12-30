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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.adamglin.composeshadow.dropShadow
import com.adamglin.composeshadow.innerShadow
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun MainCard(data: MainCardData) {
    val likes = data.likesCount
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.wrapContentWidth().dropShadow(
            shape = RectangleShape,
            color = Color.Black.copy(1f),
            offsetX = -4.dp,
            offsetY = 4.dp,
            blur = 0.dp,
            spread = 0.dp,
        ).clickable {},
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
//        WrappedTextWithMaxWidth(title)
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
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 23.dp, horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        AsyncImage(
            model = imageUrl,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .innerShadow(
                    shape = RectangleShape,
                    color = Color.Black.copy(1f),
                    offsetX = -1.dp,
                    offsetY = 1.dp,
                    blur = 0.dp,
                    spread = 4.dp,
                ).dropShadow(
                    shape = RectangleShape,
                    color = Color.White.copy(1f),
                    offsetX = -4.dp,
                    offsetY = 4.dp,
                    blur = 0.dp,
                    spread = 0.dp,
                ),
            contentScale = ContentScale.Crop
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


//fun Modifier.innerShadow(
//    color: Color = Color.Black,
//    cornersRadius: Dp = 0.dp,
//    spread: Dp = 0.dp,
//    blur: Dp = 0.dp,
//    offsetY: Dp = 0.dp,
//    offsetX: Dp = 0.dp
//) = drawWithContent {
//
//    drawContent()
//
//    val rect = Rect(Offset.Zero, size)
//    val paint = Paint()
//
//    drawIntoCanvas {
//
//        paint.color = color
//        paint.isAntiAlias = true
//        it.saveLayer(rect, paint)
//        it.drawRoundRect(
//            left = rect.left,
//            top = rect.top,
//            right = rect.right,
//            bottom = rect.bottom,
//            cornersRadius.toPx(),
//            cornersRadius.toPx(),
//            paint
//         )
//         val frameworkPaint = paint.asFrameworkPaint()
//         frameworkPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
//         if (blur.toPx() > 0) {
//             frameworkPaint.maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
//         }
//         val left = if (offsetX > 0.dp) {
//             rect.left + offsetX.toPx()
//         } else {
//             rect.left
//         }
//         val top = if (offsetY > 0.dp) {
//             rect.top + offsetY.toPx()
//         } else {
//             rect.top
//         }
//         val right = if (offsetX < 0.dp) {
//             rect.right + offsetX.toPx()
//         } else {
//             rect.right
//         }
//         val bottom = if (offsetY < 0.dp) {
//             rect.bottom + offsetY.toPx()
//         } else {
//             rect.bottom
//         }
//         paint.color = Color.Black
//         it.drawRoundRect(
//             left = left + spread.toPx() / 2,
//             top = top + spread.toPx() / 2,
//             right = right - spread.toPx() / 2,
//             bottom = bottom - spread.toPx() / 2,
//             cornersRadius.toPx(),
//             cornersRadius.toPx(),
//             paint
//         )
//         frameworkPaint.xfermode = null
//         frameworkPaint.maskFilter = null
//    }
//}