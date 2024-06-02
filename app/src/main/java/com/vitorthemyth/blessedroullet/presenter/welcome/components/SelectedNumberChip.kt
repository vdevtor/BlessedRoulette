package com.vitorthemyth.blessedroullet.presenter.welcome.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.blessedroullet.ui.theme.AccentColor
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing
import com.vitorthemyth.blessedroullet.ui.values.LocalTextDimensions

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectedNumberChip(
    number: String,
    color: Color,
    onLongClick: (number: String) -> Unit
) {
    val spacing = LocalSpacing.current
    val textDimensions = LocalTextDimensions.current


    Box(modifier = Modifier
        .semantics{ contentDescription = "SelectedNumberChip"}
        .width(50.dp)
        .height(50.dp)
        .wrapContentHeight()
        .combinedClickable(
            onLongClick = { onLongClick(number) },
            onClick = { onLongClick(number) }
        )
    ) {

        Column(
            modifier = Modifier
                .width(40.dp)
                .height(42.dp)
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
                    fontSize = textDimensions.textLarge
                ),
                textAlign = TextAlign.Center,
            )
        }

        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Excluir número",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.TopEnd)
                .offset(x = 8.dp, y = (-8).dp)
                .padding(spacing.spaceExtraSmall)
        )
    }
}


@Preview
@Composable
private fun SelectedNumberChipPreview() {
    SelectedNumberChip(
        number = "33",
        color = Color.Red
    ) {

    }
}