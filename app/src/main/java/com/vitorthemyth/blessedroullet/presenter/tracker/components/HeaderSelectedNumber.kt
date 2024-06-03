package com.vitorthemyth.blessedroullet.presenter.tracker.components

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
import androidx.compose.ui.unit.dp
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography
import com.vitorthemyth.blessedroullet.ui.values.LocalTextDimensions


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderSelectedNumber(
    number: String,
    color: Color,
    onLongClick: (number: String) -> Unit
) {
    val textDimensions = LocalTextDimensions.current


    Box(modifier = Modifier
        .semantics{ contentDescription = "SelectedNumberChip"}
        .width(30.dp)
        .height(30.dp)
        .wrapContentHeight()
        .combinedClickable(
            onLongClick = { onLongClick(number) },
            onClick = { onLongClick(number) }
        )
    ) {

        Column(
            modifier = Modifier
                .width(25.dp)
                .height(25.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(100.dp)
                )
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = number,
                style = MyTypography.iconText.copy(
                    color = Color.White,
                    fontSize = textDimensions.textMedium
                ),
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Preview
@Composable
private fun SelectedNumberChipPreview() {
    HeaderSelectedNumber(
        number = "33",
        color = Color.Red
    ) {

    }
}