package com.vitorthemyth.blessedroullet.presenter.tracker

import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

data class TrackerScreenState(
    val lastSelectedNumbers : List<RouletteNumber> = listOf()
)