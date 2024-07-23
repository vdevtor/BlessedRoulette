package com.vitorthemyth.blessedroullet.presenter.tracker.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitorthemyth.blessedroullet.core.components.HeaderTitle
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun ExpandableStrategy(
    modifier: Modifier = Modifier,
    strategy: RouletteStrategy,
    onStrategySelected: (RouletteStrategy) -> Unit
) {
    val spacing = LocalSpacing.current

    var expandedState by remember(key1 = strategy) { mutableStateOf(false) }

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f,
        label = ""
    )

    Card(
        modifier = modifier
            .padding(top = spacing.spaceIntermediate)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        backgroundColor = strategy.cardBackGroundColor,
        shape = MaterialTheme.shapes.medium,
        elevation = 99.dp,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceSmall)
            ) {
                HeaderTitle(
                    text = strategy.strategyTitle,
                    modifier = Modifier,
                    color = strategy.textColor
                )
                IconButton(
                    modifier = Modifier
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "DropDown",
                        modifier = Modifier.size(30.dp),
                        tint = strategy.textColor
                    )
                }
            }

            if (expandedState) {
                Row(
                    modifier = Modifier
                        .padding(spacing.spaceIntermediate)
                        .fillMaxWidth()
                ) {
                    FlowRow(
                        maxItemsInEachRow = 4,
                        modifier = Modifier
                            .padding(start = spacing.spaceIntermediate)
                            .weight(.4f)
                    ) {
                        strategy.playableNumbers.forEach { rouletteNumber ->
                            HeaderSelectedNumber(
                                number = rouletteNumber.number,
                                color = rouletteNumber.color,
                                onLongClick = { _ ->
                                }
                            )
                        }
                    }

                    Text(
                        text = strategy.strategyDescription,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Default,
                        color = strategy.textColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(.7f)
                            .padding(spacing.spaceExtraSmall)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(spacing.spaceIntermediate)
                        .fillMaxWidth()
                        .padding(spacing.spaceIntermediate),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column {
                        Text(
                            text = "Números altos",
                            fontSize = 14.sp,
                            color = strategy.textColor,
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            imageVector = if (strategy.placeBetOnHighNumber) {
                                Icons.Default.CheckCircle
                            } else {
                                Icons.Default.Clear
                            },
                            contentDescription = "visual icon hint for place bet",
                            modifier.align(Alignment.CenterHorizontally)
                        )
                    }

                    Column {
                        Text(
                            text = "Números baixos",
                            fontSize = 14.sp,
                            color = strategy.textColor,
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            imageVector = if (strategy.placeBetOnLowNumber) {
                                Icons.Default.CheckCircle
                            } else {
                                Icons.Default.Clear
                            },
                            contentDescription = "visual icon hint for place bet",
                            modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                    Column {
                        Text(
                            text = "Duzia",
                            fontSize = 14.sp,
                            color = strategy.textColor,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = when (strategy.playableDozen) {
                                Dozen.none -> ""
                                else -> strategy.playableDozen.order
                            },
                            fontSize = 14.sp,
                            color = strategy.textColor,
                            textAlign = TextAlign.Center,
                            modifier = modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }

                Button(
                    onClick = { onStrategySelected(strategy) },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 10.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Selecionar")
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ExpandableStrategy(
        strategy = RouletteStrategy(
            strategyTitle = "Tic Tac",
            strategyDescription = "Os 2 últimos numeros cairam na mesma duzia, selecione o modo pista para pegar vizinho da esquerda e da direita",
            playableNumbers = provideRouletteNumbers().take(10),
            playableDozen = Dozen.first,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            strategyType = StrategyType.ticTac
        )
    ) {}
}
