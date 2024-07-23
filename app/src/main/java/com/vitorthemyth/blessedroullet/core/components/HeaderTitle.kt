package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography

@Composable
fun HeaderTitle(
    text: String,
    modifier: Modifier,
    color: Color = Color.Black
) {
    Text(
        textAlign = TextAlign.Center,
        text = text,
        modifier = modifier,
        style = MyTypography.title.copy(
            color = color
        )
    )
}