package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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
            onClick = {},
            modifier = modifier,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = spacing.spaceLarge),
            colors = ButtonDefaults.buttonColors(containerColor = AccentColor, contentColor = Color.White),
            enabled = isEnabled
        ) {
            Text(
                text = text,
                style = MyTypography.subTitle.copy(fontSize = textSize)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ActionButton(modifier = Modifier, "Avançar") {}
}