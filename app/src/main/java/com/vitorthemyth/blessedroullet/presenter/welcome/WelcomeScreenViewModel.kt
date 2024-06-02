package com.vitorthemyth.blessedroullet.presenter.welcome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import com.vitorthemyth.blessedroullet.core.ui.UiEvent
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var state by mutableStateOf(WelcomeScreenState())
        private set

    private val rouletteStepList = mutableListOf<RouletteNumber>()

    fun onEvent(welcomeEvents: WelcomeEvents) {
        viewModelScope.launch {

            when (welcomeEvents) {
                WelcomeEvents.OnNextClicked -> {
                    preferences.saveLastSortedNumbers(state.selectedNumbers)
                    _uiEvent.send(UiEvent.NavigateUp)
                }

                is WelcomeEvents.OnNumberSelected -> {
                    if (state.selectedNumbers.size >= 7) {
                        _uiEvent.send(UiEvent.ShowSnackBar("Você deve adicionar apenas 7 números"))
                        return@launch
                    }
                    rouletteStepList.add(welcomeEvents.number)
                    updateSelectedNumberState()
                }

                is WelcomeEvents.OnNumberRemoved -> {
                    rouletteStepList.removeIf { welcomeEvents.number == it }
                    updateSelectedNumberState()
                }
            }
        }
    }

    private fun updateSelectedNumberState() {
        state = state.copy(
            selectedNumbers = rouletteStepList.toMutableList(),
            isReadyToGo = state.selectedNumbers.size == 6
        )
    }
}