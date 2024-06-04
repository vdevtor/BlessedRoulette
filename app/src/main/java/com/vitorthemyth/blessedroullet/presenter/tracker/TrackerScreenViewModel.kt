package com.vitorthemyth.blessedroullet.presenter.tracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.TrackerUseCases
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TrackerScreenViewModel @Inject constructor(
    private val preferences: Preferences,
    private val trackerUseCases: TrackerUseCases
) : ViewModel() {

    var state by mutableStateOf(TrackerScreenState().copy(
        lastSelectedNumbers = preferences.getLastSortedNumbers()
    ))
        private set

    private var rouletteStepList : MutableList<RouletteNumber> = mutableListOf()
    private var rouletteStrategiesStepList : MutableList<RouletteStrategy> = mutableListOf()

    init {
        analyzeAvailableStrategies()
    }

    fun onEvent(event: TrackerScreenEvents){
        when(event){
            is TrackerScreenEvents.OnNewNumberSelected->{
                rouletteStepList = state.lastSelectedNumbers.toMutableList().also {
                    it.removeLast()
                    it.add(0,event.number)
                }
                state = state.copy(lastSelectedNumbers = rouletteStepList)
                analyzeAvailableStrategies()
            }
        }
    }

    private fun analyzeAvailableStrategies(){
        rouletteStrategiesStepList.clear()

        state.lastSelectedNumbers.let {lastSelectedNumbers->

          trackerUseCases.checkTicTacStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
              rouletteStrategiesStepList.add(it)
          }

            trackerUseCases.checkFerrariStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
                rouletteStrategiesStepList.add(it)
            }
        }

        state = state.copy(availableStrategies = rouletteStrategiesStepList.toMutableList())
    }

}