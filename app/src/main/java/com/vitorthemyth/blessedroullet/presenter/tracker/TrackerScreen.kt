package com.vitorthemyth.blessedroullet.presenter.tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vitorthemyth.blessedroullet.core.components.DefaultFAB
import com.vitorthemyth.blessedroullet.core.components.HeaderTitle
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.components.SelectNumberBottomSheet
import com.vitorthemyth.blessedroullet.presenter.tracker.components.TrackerAvailableStrategies
import com.vitorthemyth.blessedroullet.presenter.tracker.components.TrackerHeader
import com.vitorthemyth.blessedroullet.ui.theme.BackgroundColor
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrackerScreen(
    viewModel: TrackerScreenViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state

    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            SelectNumberBottomSheet{
               scope.launch { modalBottomSheetState.hide() }
                viewModel.onEvent(TrackerScreenEvents.OnNewNumberSelected(it))
            }
        },
        sheetShape = MaterialTheme.shapes.medium
    ) {
        Scaffold(
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                DefaultFAB {
                    scope.launch { modalBottomSheetState.show() }
                }
            }
        ) { paddingValues ->
            paddingValues.toString()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = BackgroundColor)
            ) {
                TrackerHeader(lastSelectedNumbers = state.lastSelectedNumbers)
                HeaderTitle(
                    text = "Estratégias Disponíveis",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                TrackerAvailableStrategies(
                    availableStrategies = state.availableStrategies,
                    modifier = Modifier
                        .padding(LocalSpacing.current.spaceMedium)
                )
            }
        }
    }
}

@Composable
fun TrackerScreenPreviewlable() {
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            DefaultFAB {

            }
        }

    ) { paddingValues ->
        paddingValues.toString()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundColor)
        ) {

            //Header
            TrackerHeader(lastSelectedNumbers = emptyList())
            //Title
            HeaderTitle(
                text = "Estratégias Disponíveis",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            TrackerAvailableStrategies(
                availableStrategies = provideRouletteStrategy(),
                modifier = Modifier
                    .padding(LocalSpacing.current.spaceMedium)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    TrackerScreenPreviewlable()
}