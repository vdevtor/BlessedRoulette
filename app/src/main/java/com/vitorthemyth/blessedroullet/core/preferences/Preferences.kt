package com.vitorthemyth.blessedroullet.core.preferences

import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

interface Preferences {

    fun saveLastSortedNumbers(selectedNumbers: List<RouletteNumber>)

    fun getLastSortedNumbers(): List<RouletteNumber>

    companion object {
        const val KEY_LAST_SORTED_NUMBERS = "last_sorted_numbers"
    }
}
