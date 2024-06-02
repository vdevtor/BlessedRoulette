package com.vitorthemyth.blessedroullet.presenter.welcome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectedNumbersRow(
    selectedNumbers : List<RouletteNumber> = emptyList(),
    onNumberRemoved : (RouletteNumber) -> Unit
) {
    val spacing = LocalSpacing.current


    FlowRow(modifier = Modifier
        .fillMaxWidth()
        .padding(spacing.spaceMedium),
        horizontalArrangement = Arrangement.Center
    ) {
        selectedNumbers.forEach {   rouletteNumber->
            SelectedNumberChip(
                number = rouletteNumber.number,
                color = rouletteNumber.color
            ) { numberToRemove ->
                selectedNumbers.find { it.number == numberToRemove }?.let(onNumberRemoved)
            }
        }
    }
}

@Preview(device = "id:Galaxy Nexus", backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun SelectedNumbersRowPreview() {
    SelectedNumbersRow(
        selectedNumbers = listOf(
            RouletteNumber(
                number = "22",
                color = Color.Red,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "15",
                color = Color.Black,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "7",
                color = Color.Red,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "11",
                color = Color.Black,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "11",
                color = Color.Black,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "11",
                color = Color.Black,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "11",
                color = Color.Black,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            ),
            RouletteNumber(
                number = "11",
                color = Color.Black,
                isEven = true,
                dozen = Dozen.first,
                isHigherNumber = true
            )
        )
    ){

    }
}