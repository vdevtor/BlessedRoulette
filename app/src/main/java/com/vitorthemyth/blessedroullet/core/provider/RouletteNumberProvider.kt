package com.vitorthemyth.blessedroullet.core.provider

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber


fun provideRouletteNumbers() = listOf(
    RouletteNumber(number = "0", color = Color.Green, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "1", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "2", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "3", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "4", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "5", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "6", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "7", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "8", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "9", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "10", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "11", color = Color.Black, isEven = false, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "12", color = Color.Red, isEven = true, dozen = Dozen.first, isHigherNumber = false),
    RouletteNumber(number = "13", color = Color.Black, isEven = false, dozen = Dozen.second, isHigherNumber = false),
    RouletteNumber(number = "14", color = Color.Red, isEven = true, dozen = Dozen.second, isHigherNumber = false),
    RouletteNumber(number = "15", color = Color.Black, isEven = false, dozen = Dozen.second, isHigherNumber = false),
    RouletteNumber(number = "16", color = Color.Red, isEven = true, dozen = Dozen.second, isHigherNumber = false),
    RouletteNumber(number = "17", color = Color.Black, isEven = false, dozen = Dozen.second, isHigherNumber = false),
    RouletteNumber(number = "18", color = Color.Red, isEven = true, dozen = Dozen.second, isHigherNumber = false),
    RouletteNumber(number = "19", color = Color.Red, isEven = false, dozen = Dozen.second, isHigherNumber = true),
    RouletteNumber(number = "20", color = Color.Black, isEven = true, dozen = Dozen.second, isHigherNumber = true),
    RouletteNumber(number = "21", color = Color.Red, isEven = false, dozen = Dozen.second, isHigherNumber = true),
    RouletteNumber(number = "22", color = Color.Black, isEven = true, dozen = Dozen.second, isHigherNumber = true),
    RouletteNumber(number = "23", color = Color.Red, isEven = false, dozen = Dozen.second, isHigherNumber = true),
    RouletteNumber(number = "24", color = Color.Black, isEven = true, dozen = Dozen.second, isHigherNumber = true),
    RouletteNumber(number = "25", color = Color.Red, isEven = false, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "26", color = Color.Black, isEven = true, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "27", color = Color.Red, isEven = false, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "28", color = Color.Black, isEven = true, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "29", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "30", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "31", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "32", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "33", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "34", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "35", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true),
    RouletteNumber(number = "36", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true)
)

fun provideRouletteStrategy() = listOf(
    RouletteStrategy(
        strategyTitle = "Tic Tac",
        strategyDescription = "bla bla bla bla",
        playableNumbers = listOf(RouletteNumber(number = "33", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true),
            RouletteNumber(number = "34", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true)),
        playableDozen = Dozen.second,
        placeBetOnHighNumber = true,
        placeBetOnLowNumber = false,
    ),
    RouletteStrategy(
        strategyTitle = "Vizinhos",
        strategyDescription = "tra tra tra tra",
        playableNumbers = listOf(RouletteNumber(number = "33", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true),
            RouletteNumber(number = "34", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true)),
        playableDozen = Dozen.second,
        placeBetOnHighNumber = true,
        placeBetOnLowNumber = false
    )

)