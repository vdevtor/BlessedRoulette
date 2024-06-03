package com.vitorthemyth.blessedroullet.presenter.tracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.DarkAccentColor
import com.vitorthemyth.blessedroullet.ui.theme.OrangeColor
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing
import com.vitorthemyth.blessedroullet.ui.values.LocalTextDimensions
import kotlinx.coroutines.delay


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TrackerHeader(
    lastSelectedNumbers : List<RouletteNumber>
) {
    val textDimensions = LocalTextDimensions.current
    val spacing = LocalSpacing.current
    val currentTimeMillis = remember { mutableLongStateOf(0L) }

    LaunchedEffect(key1 = Unit ){
        val startTime = System.currentTimeMillis()
        while (true){
            delay(1000)
            currentTimeMillis.longValue = System.currentTimeMillis() - startTime
        }
    }
    Column(
        modifier = Modifier
            .padding(spacing.spaceIntermediate)
            .fillMaxWidth()
            .background(
                color = DarkAccentColor,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            modifier = Modifier
                .padding(top = spacing.spaceSmall)
                .align(Alignment.End)
                .padding(end = spacing.spaceSmall),
            text = "Horas Jogadas: ${formatTime(currentTimeMillis.longValue)}",
            fontSize = textDimensions.textSmall,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            style = TextStyle(letterSpacing = 0.5.sp),
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.height(spacing.spaceMedium))


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Últimos números \nsorteados",
                fontSize = textDimensions.textMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .padding(spacing.spaceSmall)
            )

            Text(
                text = "Última estratégia\nescolhida",
                fontSize = textDimensions.textMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .padding(spacing.spaceSmall)
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceSmall)
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            FlowRow(
                maxItemsInEachRow = 4,
                modifier = Modifier.weight(.5f)
            ) {
                lastSelectedNumbers.forEach { rouletteNumber->
                    HeaderSelectedNumber(
                        number = rouletteNumber.number,
                        color = rouletteNumber.color,
                        onLongClick = { _ ->

                        }
                    )
                }
            }

            Text(
                text = "Tic Tac",
                fontSize = textDimensions.textMedium,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(
                        color = OrangeColor,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .weight(.3f)
                    .alignBy(FirstBaseline)
                    .padding(spacing.spaceSmall)
            )
        }
    }
}

private fun formatTime(timeInMillis: Long): String {
    val seconds = (timeInMillis / 1000) % 60
    val minutes = (timeInMillis / (1000 * 60)) % 60
    val hours = (timeInMillis / (1000 * 60 * 60)) % 24
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Composable
@Preview(device = "id:pixel_xl")
private fun Preview(){
    TrackerHeader(
        lastSelectedNumbers =  listOf(
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
            )
        )
    )
}