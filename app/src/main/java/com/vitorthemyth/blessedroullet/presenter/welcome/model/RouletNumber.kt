package com.vitorthemyth.blessedroullet.presenter.welcome.model

import androidx.compose.ui.graphics.Color

data class RouletteNumber(
    val number : String,
    val color: Color,
    val isEven : Boolean,
    val dozen : Dozen,
    val isHigherNumber : Boolean,
    val closestNeighbors : List<String> = emptyList()
)

enum class Dozen(val order:String){
    first("1°"),second("2°"),third("3°"),none("")
}