package com.vitorthemyth.blessedroullet.presenter.tracker.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy

@Composable
fun TrackerAvailableStrategies(
    modifier: Modifier = Modifier,
    availableStrategies: List<RouletteStrategy>,
    onStrategySelected: (RouletteStrategy) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(availableStrategies) { rouletteStrategy ->
            ExpandableStrategy(strategy = rouletteStrategy) {
                onStrategySelected(it)
            }
        }
    }
}

@Preview
@Composable
private fun Preview(
    modifier: Modifier = Modifier
) {
    TrackerAvailableStrategies(
        availableStrategies = provideRouletteStrategy()
    ) {}
}