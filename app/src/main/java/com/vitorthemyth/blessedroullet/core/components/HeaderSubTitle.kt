package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@Composable
fun HeaderSubtitle(
    text: String,
    modifier: Modifier,
    textColor: Color = Color.Black
) {
    val spacing = LocalSpacing.current
    Text(
        textAlign = TextAlign.Center,
        text = text,
        modifier = modifier
            .padding(
                start = spacing.spaceLarge,
                end = spacing.spaceLarge,
                top = spacing.spaceSmall
            )
            .fillMaxWidth(),
        style = MyTypography.subTitle.copy(color = textColor)
    )
}