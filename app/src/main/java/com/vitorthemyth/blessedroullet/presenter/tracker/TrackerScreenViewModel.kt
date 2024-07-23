package com.vitorthemyth.blessedroullet.presenter.tracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyTag
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.TrackerUseCases
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackerScreenViewModel @Inject constructor(
    private val preferences: Preferences,
    private val trackerUseCases: TrackerUseCases
) : ViewModel() {

    var state by mutableStateOf(
        TrackerScreenState().copy(
            lastSelectedNumbers = preferences.getLastSortedNumbers()
        )
    )
        private set

    private var rouletteStepList: MutableList<RouletteNumber> = mutableListOf()
    private var rouletteStrategiesStepList: MutableList<RouletteStrategy> = mutableListOf()

    init {
        analyzeAvailableStrategies()
    }

    fun onEvent(event: TrackerScreenEvents) {
        when (event) {
            is TrackerScreenEvents.OnNewNumberSelected -> {
                rouletteStepList = state.lastSelectedNumbers.toMutableList().also {
                    it.removeLast()
                    it.add(0, event.number)
                }
                state = state.copy(lastSelectedNumbers = rouletteStepList)
                analyzeAvailableStrategies()
            }

            is TrackerScreenEvents.OnNewStrategySelected -> {
                state = state.copy(lastStrategy = event.strategy)
            }
        }
    }

    private fun analyzeAvailableStrategies() {
        rouletteStrategiesStepList.clear()

        state.lastSelectedNumbers.let {lastSelectedNumbers->
            //standard strategies
            analyzeStandardStrategies(lastSelectedNumbers)

            //Premium strategies
            analyzePremiumStrategies(lastSelectedNumbers)
        }

        state = state.copy(availableStrategies = rouletteStrategiesStepList.toMutableList().sortedByDescending { it.tag })
    }

    private fun analyzeStandardStrategies(lastSelectedNumbers: List<RouletteNumber>){
        trackerUseCases.checkTicTacStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.checkFerrariStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.checkEvenOddStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.checkOneByOneStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.checkExtremeStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.checkMirrorStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.checkArcherStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.checkBugattiStrategy(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

    }

    private fun analyzePremiumStrategies(lastSelectedNumbers: List<RouletteNumber>){
        trackerUseCases.check30AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.check17AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.check22AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.check21AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.check20AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.check3AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
        trackerUseCases.check13AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.check26AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.check14AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.check27AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.check24AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.check23AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }

        trackerUseCases.check33AndNeighbors(lastSelectedNumbers).takeIf { it != null }?.let {
            rouletteStrategiesStepList.add(it)
        }
    }
}
