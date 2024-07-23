package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RouletteNumber(
    number: String,
    color: Color,
    boxSize: Dp = 30.dp,
    ballSize: Dp = 25.dp,
    textSize: TextUnit = 18.sp,
    onLongClick: (number: String) -> Unit
) {
    Box(
        modifier = Modifier
            .semantics { contentDescription = "SelectedNumberChip" }
            .width(boxSize)
            .height(boxSize)
            .wrapContentHeight()
            .combinedClickable(
                onLongClick = { onLongClick(number) },
                onClick = { onLongClick(number) }
            )
    ) {
        Column(
            modifier = Modifier
                .width(ballSize)
                .height(ballSize)
                .background(
                    color = color,
                    shape = RoundedCornerShape(100.dp)
                )
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = number,
                style = MyTypography.iconText.copy(
                    color = Color.White,
                    fontSize = textSize
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    RouletteNumber(
        number = "33",
        color = Color.Red
    ) {
    }
}
