package com.vitorthemyth.blessedroullet.presenter.welcome.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.vitorthemyth.blessedroullet.core.components.AvailableNumber
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

@Composable
fun AvailableNumbersGrid(
    modifier: Modifier,
    onClick: (RouletteNumber) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 4),
        modifier = modifier.semantics { contentDescription = "availableNumbersList" }
    ) {
        items(provideRouletteNumbers()) {
            AvailableNumber(rouletteNumber = it, modifier = Modifier) { number ->
                onClick(number)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AvailableNumbersGrid(
        modifier = Modifier
    ) {
    }
}