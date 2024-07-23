package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitorthemyth.blessedroullet.ui.theme.AccentColor
import com.vitorthemyth.blessedroullet.ui.theme.MyTypography
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@Composable
fun ActionButton(
    modifier: Modifier,
    text: String,
    textSize: TextUnit = 20.sp,
    isEnabled: Boolean = true,
    onAction: () -> Unit
) {
    val spacing = LocalSpacing.current
    MaterialTheme {
        Button(
            onClick = { onAction() },
            modifier = modifier,
            elevation = ButtonDefaults.elevation(defaultElevation = spacing.spaceLarge),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AccentColor,
                contentColor = Color.White
            ),
            enabled = isEnabled,
            shape = RoundedCornerShape(100.dp)
        ) {
            Text(
                text = text,
                style = MyTypography.subTitle.copy(fontSize = textSize),
                modifier = Modifier.padding(spacing.spaceExtraSmall)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ActionButton(modifier = Modifier, "Avançar") {}
}