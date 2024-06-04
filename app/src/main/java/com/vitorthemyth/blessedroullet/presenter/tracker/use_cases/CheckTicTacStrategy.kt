package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber

class CheckTicTacStrategy {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null
        val firstNumber = list[0]
        val secondNumber = list[1]

        val isRed = firstNumber.color == Color.Red && secondNumber.color == Color.Red
        val isBlack = firstNumber.color == Color.Black && secondNumber.color == Color.Black
        val isHigh = firstNumber.isHigherNumber && secondNumber.isHigherNumber
        val isLow = !firstNumber.isHigherNumber && !secondNumber.isHigherNumber


        if ((!isRed && !isBlack) || (!isHigh && !isLow)) return null

        val strategyTitle = "Tic Tac"
        val strategyDescription =
            "Jogue o inverso dos dois ultimos numero baseando-se nas cores e altos/baixos"


        val playableNumbers = when {
            isRed && isHigh -> provideRouletteNumbers().filter { !it.isHigherNumber && it.color == Color.Black }
            isBlack && isLow -> provideRouletteNumbers().filter { it.isHigherNumber && it.color == Color.Red }
            isBlack && isHigh -> provideRouletteNumbers().filter { !it.isHigherNumber && it.color == Color.Red }
            isRed && isLow -> provideRouletteNumbers().filter { it.isHigherNumber && it.color == Color.Black }
            else -> emptyList()
        }

        return RouletteStrategy(
            strategyTitle = strategyTitle,
            strategyDescription = strategyDescription,
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            strategyType = StrategyType.ticTac
        )
    }
}