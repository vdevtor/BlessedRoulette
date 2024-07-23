package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.values.LocalTextDimensions

@Composable
fun AvailableNumber(
    rouletteNumber: RouletteNumber,
    modifier: Modifier,
    onClicked: (RouletteNumber) -> Unit
) {
    val textDimensions = LocalTextDimensions.current
    RouletteNumber(
        number = rouletteNumber.number,
        color = rouletteNumber.color,
        boxSize = 60.dp,
        ballSize = 55.dp,
        textSize = textDimensions.textExtraLarge
    ) {
        onClicked(rouletteNumber)
    }
}

@Preview
@Composable
private fun Preview() {
    AvailableNumber(
        rouletteNumber = RouletteNumber(
            number = "22",
            color = Color.Black,
            isEven = false,
            dozen = Dozen.second,
            isHigherNumber = false
        ),
        modifier = Modifier
    ) {}
}