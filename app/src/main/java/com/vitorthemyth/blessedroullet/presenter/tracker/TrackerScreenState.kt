package com.vitorthemyth.blessedroullet.presenter.tracker

import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

data class TrackerScreenState(
    val lastSelectedNumbers : List<RouletteNumber> = listOf(),
    val availableStrategies : List<RouletteStrategy> = listOf(),
    val lastStrategy: RouletteStrategy? = null
)