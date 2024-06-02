package com.vitorthemyth.blessedroullet.util

import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

class FakePreferences : Preferences {
    var cachedData = mutableListOf<Any>()

    override fun saveLastSortedNumbers(selectedNumbers: List<RouletteNumber>) {
        cachedData = selectedNumbers.toMutableList()
    }

    override fun getLastSortedNumbers(): List<RouletteNumber> {
        return cachedData.filterIsInstance(RouletteNumber::class.java)
    }
}