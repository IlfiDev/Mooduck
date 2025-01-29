package org.ilfidev.mooduck.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adamglin.composeshadow.dropShadow
import com.adamglin.composeshadow.innerShadow
import mooduck.composeapp.generated.resources.Res
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun SearchBarWithButtons(
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    height: Dp = 40.dp,
    elevation: Dp = 3.dp,
    cornerShape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.White,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = cornerShape)
            .background(color = backgroundColor, shape = cornerShape)
            .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier = modifier
                .weight(5f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = text,
            onValueChange = {
                text = it
                onTextChange(it.text)
            },
            enabled = isEnabled,
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            decorationBox = { innerTextField ->
                if (text.text.isEmpty()) {
                    Text(
                        text = hint,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
            singleLine = true
        )
        Box(
            modifier = modifier
                .weight(1f)
                .size(40.dp)
                .background(color = Color.Transparent, shape = CircleShape)
                .clickable {
                    if (text.text.isNotEmpty()) {
                        text = TextFieldValue(text = "")
                        onTextChange("")
                    }
                },
        ) {
            if (text.text.isNotEmpty()) {
                //                Icon(
                //                    modifier = modifier
                //                        .fillMaxSize()
                //                        .padding(10.dp),
                //                    painter = painterResource(id = R.drawable.baseline_clear_24),
                //                    contentDescription = stringResource(R.string.search),
                //                    tint = MaterialTheme.colorScheme.primary,
                //                )
            } else {
                //                Icon(
                //                    modifier = modifier
                //                        .fillMaxSize()
                //                        .padding(Dimens.dp10),
                //                    painter = painterResource(id = R.drawable.ic_search),
                //                    contentDescription = stringResource(R.string.search),
                //                    tint = MaterialTheme.colorScheme.primary,
                //                )
            }
        }
    }
}


//@Composable
//fun DefaultTextField(value: String, hintText: String = "", onValueChange: () -> Unit = {}) {
//    BasicTextField(
//        value = TextFieldValue(text = value),
//        onValueChange = onValueChange,
//        modifier = Modifier.fillMaxWidth()
//            .height(41.dp)
//            .innerShadow(
//                shape = RectangleShape,
//                color = Color.Black.copy(1f),
//                offsetX = -1.dp,
//                offsetY = 1.dp,
//                blur = 0.dp,
//                spread = 4.dp,
//            ).dropShadow(
//                shape = RectangleShape,
//                color = Color.White.copy(0.8f),
//                offsetX = -4.dp,
//                offsetY = 4.dp,
//                blur = 0.dp,
//                spread = 0.dp,
//            ),
//    )
//}


@Preview
@Composable
fun DefaultTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {
//    var text by remember { mutableStateOf(TextFieldValue()) }
    var textState by remember { mutableStateOf(TextFieldValue(text)) }
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(41.dp)
            .innerShadow(
                shape = RectangleShape,
                color = Color.Black.copy(1f),
                offsetX = -1.dp,
                offsetY = 1.dp,
                blur = 0.dp,
                spread = 4.dp,
            ).dropShadow(
                shape = RectangleShape,
                color = Color.White.copy(0.8f),
                offsetX = -4.dp,
                offsetY = 4.dp,
                blur = 0.dp,
                spread = 0.dp,
            ),
        value = textState,
        onValueChange = {
            textState = it
            onTextChange(it.text)
        },
        enabled = isEnabled,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        decorationBox = { innerTextField ->
            if (textState.text.isEmpty()) {
                Text(
                    text = hint,
                    color = Color.Gray.copy(alpha = 0.5f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            } else {

            }
            innerTextField()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
        singleLine = true
    )
}

@Composable
@Preview()
fun DefaultTextFieldPreview() {
//    DefaultTextField("", hintText = "Login")
}