package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.GreenColor

class CheckEvenOddStrategy {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val firstNumber = list[0]
        val secondNumber = list[1]

        val isEven = (firstNumber.number.toInt() % 2 == 0) && (secondNumber.number.toInt() % 2 == 0)
        val isOdd = (firstNumber.number.toInt() % 2 != 0) && (secondNumber.number.toInt() % 2 != 0)
        val isHigh = firstNumber.isHigherNumber && secondNumber.isHigherNumber
        val isLow = !firstNumber.isHigherNumber && !secondNumber.isHigherNumber

        if ((!isEven && !isOdd) || (!isHigh && !isLow)) return null

        val playableNumbers = when {
            isEven && isHigh -> provideRouletteNumbers().filter { !it.isHigherNumber && (it.number.toInt() % 2 != 0) }
            isOdd && isLow -> provideRouletteNumbers().filter { it.isHigherNumber && (it.number.toInt() % 2 == 0) }
            isOdd && isHigh -> provideRouletteNumbers().filter { !it.isHigherNumber && (it.number.toInt() % 2 == 0) }
            isEven && isLow -> provideRouletteNumbers().filter { it.isHigherNumber && (it.number.toInt() % 2 != 0) }
            else -> emptyList()
        }
        return RouletteStrategy(
            strategyTitle = "Impar ou Par",
            strategyDescription = "Os 2 últimos números são impares/pares e altos ou baixos. Jogue no oposto a eles!",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = !isHigh,
            placeBetOnLowNumber = !isLow,
            cardBackGroundColor = GreenColor,
            strategyType = StrategyType.evenOdd,
            textColor = Color.White
        )
    }
}