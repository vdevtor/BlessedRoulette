package com.vitorthemyth.blessedroullet.presenter.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vitorthemyth.blessedroullet.core.components.ActionButton
import com.vitorthemyth.blessedroullet.core.components.HeaderSubtitle
import com.vitorthemyth.blessedroullet.core.components.HeaderTitle
import com.vitorthemyth.blessedroullet.core.ui.UiEvent
import com.vitorthemyth.blessedroullet.presenter.welcome.components.AvailableNumbersGrid
import com.vitorthemyth.blessedroullet.presenter.welcome.components.SelectedNumbersRow
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing
import kotlinx.coroutines.flow.collectLatest

@Composable
fun WelcomeScreen(
    snackBarHostState: SnackbarHostState,
    viewModel: WelcomeScreenViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state

    LaunchedEffect(snackBarHostState) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(
                        message = event.message
                    )
                }

                UiEvent.NavigateUp -> {
                    onNavigateUp()
                }

                else -> Unit
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        HeaderTitle(
            text = "Bem vindo ao Blessed Roulette",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = spacing.spaceLarge)
                .padding(
                    start = spacing.spaceLarge,
                    end = spacing.spaceLarge,
                    top = spacing.spaceSmall
                )
        )

        HeaderSubtitle(
            text = "Informe os ultimos 7 numeros sorteados na roleta",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        SelectedNumbersRow(
            selectedNumbers = state.selectedNumbers
        ) { numberRemoved ->
            viewModel.onEvent(WelcomeEvents.OnNumberRemoved(numberRemoved))
        }
        ActionButton(
            modifier = Modifier
                .padding(spacing.spaceMedium)
                .align(Alignment.CenterHorizontally),
            text = "Avançar",
            isEnabled = state.isReadyToGo
        ) {
            viewModel.onEvent(WelcomeEvents.OnNextClicked)
        }

        AvailableNumbersGrid(Modifier) { rouletteNumber ->
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
            .background(color = MaterialTheme.colors.background)
    ) {
        HeaderTitle(
            text = "Bem vindo ao Blessed Roulette",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                .padding(top = spacing.spaceLarge)
                .padding(
                    start = spacing.spaceLarge,
                    end = spacing.spaceLarge,
                    top = spacing.spaceSmall
                )
        )

        HeaderSubtitle(
            text = "Informe os ultimos 7 numeros sorteados na roleta",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        SelectedNumbersRow(
            selectedNumbers = numberlist
        ) { _ ->
        }

        ActionButton(
            modifier = Modifier
                .padding(spacing.spaceMedium)
                .align(Alignment.CenterHorizontally),
            text = "Avançar",
            isEnabled = numberlist.size == 7
        ) {
        }

        AvailableNumbersGrid(Modifier) {}
    }
}

@Preview(device = "id:pixel_4_xl")
@Composable
private fun Preview() {
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
