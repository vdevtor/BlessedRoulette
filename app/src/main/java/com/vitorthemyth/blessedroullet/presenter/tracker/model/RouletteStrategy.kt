package com.vitorthemyth.blessedroullet.presenter.tracker.model

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

data class RouletteStrategy(
    val strategyTitle: String,
    val strategyDescription: String,
    val playableNumbers: List<RouletteNumber>,
    val playableDozen: Dozen,
    val placeBetOnHighNumber: Boolean = false,
    val placeBetOnLowNumber: Boolean = false,
    val cardBackGroundColor: Color = Color.Yellow,
    val strategyType: StrategyType = StrategyType.none,
    val textColor: Color = Color.Black,
    val tag: StrategyTag = StrategyTag.standard
)

enum class StrategyType {
    ticTac,
    ferrari,
    evenOdd,
    oneByOne,
    extreme,
    mirror,
    archer,
    bugatti,
    thirtyAndNeighbors,
    seventeenAndNeighbors,
    twentyTwoAndNeighbors,
    twentyOneAndNeighbors,
    twentyAndNeighbors,
    threeAndNeighbors,
    thirteenAndNeighbors,
    twentySixAndNeighbors,
    fourteenAndNeighbors,
    twentySevenAndNeighbors,
    twentyFourAndNeighbors,
    twentyThreeAndNeighbors,
    thirtyThreeAndNeighbors,
    none
}
enum class StrategyTag {
    standard, premium
}
