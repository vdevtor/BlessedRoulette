package com.vitorthemyth.blessedroullet.presenter.tracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TrackerScreenViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var state by mutableStateOf(TrackerScreenState().copy(
        lastSelectedNumbers = preferences.getLastSortedNumbers()
    ))
        private set


}