package com.vitorthemyth.blessedroullet.presenter.welcome.model

import androidx.compose.ui.graphics.Color

data class RouletteNumber(
    val number : String,
    val color: Color,
    val isEven : Boolean,
    val dozen : Dozen,
    val isHigherNumber : Boolean
)

enum class Dozen{
    first,second,third,none
}