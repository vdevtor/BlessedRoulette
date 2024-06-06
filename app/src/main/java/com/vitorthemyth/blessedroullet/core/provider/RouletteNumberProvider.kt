package com.vitorthemyth.blessedroullet.core.provider

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.QuarterOrder
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteQuarter


fun provideRouletteNumbers() = listOf(
    RouletteNumber(number = "0", color = Color.Green, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("3","26","32","15"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "1", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("16","33","20","14"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "2", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("4","21","25","17"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "3", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("12","35","26","0"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "4", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("15","19","21","2"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "5", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("32","10","24","16"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "6", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("17","34","27","13"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "7", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("18","29","28","12"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "8", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("11","30","23","10"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "9", color = Color.Red, isEven = false, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("14","31","22","18"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "10", color = Color.Black, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("8","23","5","24"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "11", color = Color.Black, isEven = false, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("13","36","30","8"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "12", color = Color.Red, isEven = true, dozen = Dozen.first, isHigherNumber = false, closestNeighbors = listOf("7","28","35","3"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "13", color = Color.Black, isEven = false, dozen = Dozen.second, isHigherNumber = false, closestNeighbors = listOf("6","27","36","11"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "14", color = Color.Red, isEven = true, dozen = Dozen.second, isHigherNumber = false, closestNeighbors = listOf("1","20","31","9"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "15", color = Color.Black, isEven = false, dozen = Dozen.second, isHigherNumber = false, closestNeighbors = listOf("0","32","19","4"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "16", color = Color.Red, isEven = true, dozen = Dozen.second, isHigherNumber = false, closestNeighbors = listOf("5","24","33","1"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "17", color = Color.Black, isEven = false, dozen = Dozen.second, isHigherNumber = false, closestNeighbors = listOf("2","25","34","6"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "18", color = Color.Red, isEven = true, dozen = Dozen.second, isHigherNumber = false, closestNeighbors = listOf("9","22","29","7"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "19", color = Color.Red, isEven = false, dozen = Dozen.second, isHigherNumber = true, closestNeighbors = listOf("32","15","4","21"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "20", color = Color.Black, isEven = true, dozen = Dozen.second, isHigherNumber = true, closestNeighbors = listOf("33","01","14","31"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "21", color = Color.Red, isEven = false, dozen = Dozen.second, isHigherNumber = true, closestNeighbors = listOf("19","4","2","25"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "22", color = Color.Black, isEven = true, dozen = Dozen.second, isHigherNumber = true, closestNeighbors = listOf("31","9","18","29"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "23", color = Color.Red, isEven = false, dozen = Dozen.second, isHigherNumber = true, closestNeighbors = listOf("30","8","10","5"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "24", color = Color.Black, isEven = true, dozen = Dozen.second, isHigherNumber = true, closestNeighbors = listOf("10","5","16","33"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "25", color = Color.Red, isEven = false, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("21","2","17","34"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "26", color = Color.Black, isEven = true, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("35","3","0","32"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "27", color = Color.Red, isEven = false, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("34","6","27","13"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "28", color = Color.Black, isEven = true, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("29","7","12","35"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "29", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("22","18","7","28"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "30", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("36","11","8","23"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "31", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("20","14","9","22"), rouletteQuarter = provideRouletteFourthQuarter()),
    RouletteNumber(number = "32", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("26","0","15","19"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "33", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("24","16","1","20"), rouletteQuarter = provideRouletteThirdQuarter()),
    RouletteNumber(number = "34", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("25","17","6","27"), rouletteQuarter = provideRouletteSecondQuarter()),
    RouletteNumber(number = "35", color = Color.Black, isEven = false, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("28","12","3","26"), rouletteQuarter = provideRouletteFirstQuarter()),
    RouletteNumber(number = "36", color = Color.Red, isEven = true, dozen = Dozen.third, isHigherNumber = true, closestNeighbors = listOf("27","13","11","30"), rouletteQuarter = provideRouletteSecondQuarter())
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


fun provideRouletteFirstQuarter() = RouletteQuarter(
    numbers = listOf("12", "35", "3","26","0","32","15","19","4"),
    quarterMirrorNumber = "5",
    quarterOrder = QuarterOrder.first
)

fun provideRouletteSecondQuarter() = RouletteQuarter(
    numbers = listOf("21", "2", "25","17","34","6","27","13","36"),
    quarterMirrorNumber = "22",
    quarterOrder = QuarterOrder.second
)

fun provideRouletteThirdQuarter() = RouletteQuarter(
    numbers = listOf("11", "30", "8","23","10","5","24","16","33","1"),
    quarterMirrorNumber = "0",
    quarterOrder = QuarterOrder.third
)

fun provideRouletteFourthQuarter() = RouletteQuarter(
    numbers = listOf("20", "14", "31","9","22","18","29","7","28"),
    quarterMirrorNumber = "34",
    quarterOrder = QuarterOrder.fourth
)