package com.vitorthemyth.blessedroullet.presenter.welcome

import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

data class WelcomeScreenState(
    val selectedNumbers: List<RouletteNumber> = listOf(),
    val isReadyToGo: Boolean = false
)