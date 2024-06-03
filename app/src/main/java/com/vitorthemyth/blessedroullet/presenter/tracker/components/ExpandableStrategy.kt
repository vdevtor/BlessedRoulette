package com.vitorthemyth.blessedroullet.presenter.tracker.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.blessedroullet.core.components.HeaderTitle
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableStrategy(
    modifier: Modifier = Modifier,
    strategy: RouletteStrategy
) {

    val spacing = LocalSpacing.current

    var expandedState by remember { mutableStateOf(false) }

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = ""
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
                HeaderTitle(text = strategy.strategyTitle, modifier = Modifier, color = Color.Black)
                IconButton(
                    modifier = Modifier
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "DropDown",
                        modifier = Modifier.size(30.dp)
                    )
                }

            }

            if (expandedState){
                Text(text = "Inside the Card, a Column composable is used to arrange the card’s content vertically. Within the column, a Row composable arranges the title and the expand/collapse arrow icon horizontally. The Text composable displays the title and description, while the IconButton composable holds the arrow icon. The arrow’s rotation is controlled by the rotationState, and the description text’s visibility depends on the expandedState.")
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    ExpandableStrategy(
        strategy = RouletteStrategy(
            strategyTitle = "Tic Tac",
            strategyDescription = "vituperata",
            playableNumbers = listOf(),
            playableDozen =Dozen.first,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false
        )
    )
}