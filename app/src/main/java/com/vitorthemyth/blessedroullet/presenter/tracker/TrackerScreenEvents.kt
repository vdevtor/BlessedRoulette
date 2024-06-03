package com.vitorthemyth.blessedroullet.presenter.tracker

import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

sealed class TrackerScreenEvents {
    data class OnNewNumberSelected(val number:RouletteNumber) : TrackerScreenEvents()
}