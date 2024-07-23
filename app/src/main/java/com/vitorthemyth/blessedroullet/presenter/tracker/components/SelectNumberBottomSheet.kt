package com.vitorthemyth.blessedroullet.presenter.tracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.blessedroullet.core.components.HeaderSubtitle
import com.vitorthemyth.blessedroullet.core.components.RouletteNumber
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.BackgroundColor
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectNumberBottomSheet(
    modifier: Modifier = Modifier,
    onNumberClicked: (RouletteNumber) -> Unit
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier.fillMaxWidth().background(color = BackgroundColor)
    ) {
        HeaderSubtitle(
            text = "Adicione o último número \nsorteado",
            modifier = modifier.padding(spacing.spaceSmall),
            textColor = Color.Black
        )

        Spacer(modifier = modifier.height(spacing.spaceMedium))

        FlowRow(
            modifier = modifier.fillMaxWidth().padding(spacing.spaceSmall),
            maxItemsInEachRow = 5,
            horizontalArrangement = Arrangement.spacedBy(
                spacing.spaceMedium,
                alignment = Alignment.CenterHorizontally
            )

        ) {
            provideRouletteNumbers().forEach {
                RouletteNumber(
                    number = it.number,
                    color = it.color,
                    boxSize = 45.dp,
                    ballSize = 40.dp
                ) { number ->
                    provideRouletteNumbers().find { it.number == number }?.let(onNumberClicked)
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(modifier: Modifier = Modifier) {
    SelectNumberBottomSheet {}
}
