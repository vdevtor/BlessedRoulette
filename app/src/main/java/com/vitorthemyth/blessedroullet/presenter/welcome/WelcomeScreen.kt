package com.vitorthemyth.blessedroullet.presenter.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vitorthemyth.blessedroullet.core.components.ActionButton
import com.vitorthemyth.blessedroullet.core.components.HeaderSubtitle
import com.vitorthemyth.blessedroullet.core.components.HeaderTitle
import com.vitorthemyth.blessedroullet.presenter.welcome.components.AvailableNumbersGrid
import com.vitorthemyth.blessedroullet.presenter.welcome.components.SelectedNumbersRow
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing

@Composable
fun WelcomeScreen(
    viewModel: WelcomeScreenViewModel = hiltViewModel(),
    onNextClick: () -> Unit,
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        HeaderTitle(text = "Bem vindo ao Blessed Roulette" ,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

       HeaderSubtitle(
           text = "Informe os ultimos 7 numeros sorteados na roleta",
           modifier = Modifier.align(Alignment.CenterHorizontally)
       )

        SelectedNumbersRow(
            selectedNumbers = state.selectedNumbers
        ){ numberRemoved ->
            viewModel.onEvent(WelcomeEvents.OnNumberRemoved(numberRemoved))
        }
        ActionButton(
            modifier = Modifier
                .padding(spacing.spaceMedium)
                .align(Alignment.CenterHorizontally),
            text = "Avançar",
            isEnabled = state.isReadyToGo
        ) {

        }

        AvailableNumbersGrid(Modifier){rouletteNumber ->
                viewModel.onEvent(WelcomeEvents.OnNumberSelected(rouletteNumber))
        }
    }
}

@Composable
fun WelcomeScreenPreviewlable(
    numberlist: List<RouletteNumber>
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        HeaderTitle(text = "Bem vindo ao Blessed Roulette" ,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        HeaderSubtitle(
            text = "Informe os ultimos 7 numeros sorteados na roleta",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        SelectedNumbersRow(
            selectedNumbers = numberlist
        ){ numberRemoved ->

        }

        ActionButton(
            modifier = Modifier
                .padding(spacing.spaceMedium)
                .align(Alignment.CenterHorizontally),
            text = "Avançar",
            isEnabled = numberlist.size == 7
        ) {

        }

        AvailableNumbersGrid(Modifier){}
    }
}

@Preview(device = "id:pixel_4_xl")
@Composable
private fun Preview(){
    WelcomeScreenPreviewlable(
       numberlist = listOf(
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
            )
        )
    )
}