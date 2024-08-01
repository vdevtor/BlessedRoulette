package com.vitorthemyth.blessedroullet.core.ui

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()
    data class ShowSnackBar(val message: String) : UiEvent()
}
