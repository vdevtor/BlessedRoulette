package com.vitorthemyth.blessedroullet.presenter.welcome.model

import androidx.compose.ui.graphics.Color

data class RouletteNumber(
    val number: String,
    val color: Color,
    val isEven: Boolean,
    val dozen: Dozen,
    val isHigherNumber: Boolean,
    val closestNeighbors: List<String> = emptyList(),
    val rouletteQuarter: RouletteQuarter = RouletteQuarter()
)

data class RouletteQuarter(
    val numbers: List<String> = listOf(),
    val quarterMirrorNumber: String = "",
    val quarterOrder: QuarterOrder = QuarterOrder.none
)

enum class QuarterOrder(val position: Int) {
    first(1), second(2), third(3), fourth(4), none(99)
}

enum class Dozen(val order: String) {
    first("1°"), second("2°"), third("3°"), none("")
}