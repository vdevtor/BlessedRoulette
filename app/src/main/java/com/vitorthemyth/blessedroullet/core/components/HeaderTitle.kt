package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@Composable
fun HeaderTitle(
   text : String,
   modifier: Modifier
) {
    val spacing = LocalSpacing.current
    Text(
        textAlign = TextAlign.Center,
        text = text,
        modifier = modifier
            .padding(top = spacing.spaceLarge)
            .padding(
                start = spacing.spaceLarge,
                end = spacing.spaceLarge,
                top = spacing.spaceSmall
            ),
        style = MyTypography.title
    )
}