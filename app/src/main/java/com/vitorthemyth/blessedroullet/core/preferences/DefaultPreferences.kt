package com.vitorthemyth.blessedroullet.core.preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun saveLastSortedNumbers(selectedNumbers: List<RouletteNumber>) {
        val dataAsString = Gson().toJson(selectedNumbers)
        sharedPreferences.edit().putString(
            Preferences.KEY_LAST_SORTED_NUMBERS,
            dataAsString
        ).apply()
    }

    override fun getLastSortedNumbers(): List<RouletteNumber> {
        return sharedPreferences.getString(Preferences.KEY_LAST_SORTED_NUMBERS, null)?.let {
            val listType = object : TypeToken<List<RouletteNumber>>() {}.type
            val numbersFromJson: List<RouletteNumber> = Gson().fromJson(it, listType)
            numbersFromJson
        } ?: emptyList()
    }
}
