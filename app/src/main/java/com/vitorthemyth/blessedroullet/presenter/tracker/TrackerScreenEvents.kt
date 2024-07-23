package com.vitorthemyth.blessedroullet.presenter.tracker

import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

sealed class TrackerScreenEvents {
    data class OnNewNumberSelected(val number: RouletteNumber) : TrackerScreenEvents()
    data class OnNewStrategySelected(val strategy: RouletteStrategy) : TrackerScreenEvents()
}