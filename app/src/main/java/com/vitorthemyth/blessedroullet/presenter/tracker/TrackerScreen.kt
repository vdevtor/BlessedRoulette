package com.vitorthemyth.blessedroullet.presenter.tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vitorthemyth.blessedroullet.core.components.DefaultFAB
import com.vitorthemyth.blessedroullet.core.components.HeaderTitle
import com.vitorthemyth.blessedroullet.presenter.tracker.components.TrackerHeader
import com.vitorthemyth.blessedroullet.ui.theme.AccentColor
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
            Text("sheetContent", modifier = Modifier.fillMaxHeight())
        },
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
                    .background(color = AccentColor)
            ) {
                TrackerHeader(lastSelectedNumbers = state.lastSelectedNumbers)
                HeaderTitle(
                    text = "Estratégias Disponíveis",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color.White
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
                .background(color = AccentColor)
        ) {

            //Header
            TrackerHeader(lastSelectedNumbers = emptyList())
            //Title
            HeaderTitle(
                text = "Estratégias Disponíveis",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            //Recycler
        }
    }
}

@Preview
@Composable
private fun Preview() {
    TrackerScreenPreviewlable()
}