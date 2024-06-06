package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.PinkColor

class CheckExtremeStrategy {


    operator fun invoke(list: List<RouletteNumber>) : RouletteStrategy?{
        if (list.size < 2) return null

        val firstNumber = list[0]
        val secondNumber = list[1]

        var playableDozen : Dozen = Dozen.none

        when{
            secondNumber.dozen == Dozen.second -> return null

            secondNumber.dozen == Dozen.third &&
                    firstNumber.dozen != Dozen.second -> return null

            secondNumber.dozen == Dozen.third &&
                    firstNumber.dozen == Dozen.second -> playableDozen = Dozen.first


            secondNumber.dozen == Dozen.first &&
                    firstNumber.dozen != Dozen.second -> return null

            secondNumber.dozen == Dozen.first &&
                    firstNumber.dozen == Dozen.second -> playableDozen = Dozen.third

            else -> Dozen.none
        }

        if (playableDozen == Dozen.none) return null

        val filteredList = provideRouletteNumbers().filter {
            it.dozen == playableDozen
        }


        val indicesToKeep = setOf(0, 2, 3, 5, 6, 8, 9, 11)

        val playableNumbers = filteredList.filterIndexed { index, _ -> index in indicesToKeep }

        return RouletteStrategy(
            strategyTitle = "Extreme",
            strategyDescription = "Duzias em sequência, você deve jogar nas extremidades da proxima duzia. e.g 1º -> 2º = 3º duzia,3º -> 2º = 1º duzia",
            playableNumbers = playableNumbers,
            playableDozen = playableDozen,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = PinkColor,
            strategyType = StrategyType.extreme,
            textColor = Color.White
        )
    }
}