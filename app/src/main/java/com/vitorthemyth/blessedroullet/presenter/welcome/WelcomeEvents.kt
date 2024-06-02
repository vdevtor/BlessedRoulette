package com.vitorthemyth.blessedroullet.presenter.welcome

import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

sealed class WelcomeEvents {

    data class OnNumberSelected(val number : RouletteNumber) : WelcomeEvents()
    data class OnNumberRemoved(val number : RouletteNumber) : WelcomeEvents()

    object OnNextClicked : WelcomeEvents()
}