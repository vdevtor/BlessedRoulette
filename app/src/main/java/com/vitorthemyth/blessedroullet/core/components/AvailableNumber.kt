package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
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
    Box(
        modifier = modifier
            .background(color = rouletteNumber.color)
            .width(100.dp)
            .border(width = 1.dp, color = Color.White)
            .clickable { onClicked(rouletteNumber)}
        ,
        contentAlignment = Alignment.Center,
    ){
        Text(
            text = rouletteNumber.number,
            color = Color.White,
            fontSize = textDimensions.textExtraLarge,
            fontFamily = FontFamily.Serif
        )
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
    ){}

}