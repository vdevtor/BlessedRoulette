package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.DarkGray

class CheckMirrorStrategy {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val firstNumber = list[0]
        val secondNumber = list[1]
        val thirdNumber = list[2]

        val currentQuarter = firstNumber.rouletteQuarter.quarterOrder

        val isSameQuarter = (secondNumber.rouletteQuarter.quarterOrder == currentQuarter)
            .and(thirdNumber.rouletteQuarter.quarterOrder == currentQuarter)

        if (!isSameQuarter) return null

        val mirrorNumber = firstNumber.rouletteQuarter.quarterMirrorNumber

        val playableNumbers = provideRouletteNumbers()
            .find { it.number == mirrorNumber }
            ?.let { number ->
                provideRouletteNumbers().filter {
                    number.rouletteQuarter.numbers.contains(it.number)
                }
            } ?: return null

        return RouletteStrategy(
            strategyTitle = "Espelho",
            strategyDescription = "Os 3 últimos números cairam no mesmo quarto da roleta, jogue nos vizinhos do quarto oposto.",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = DarkGray,
            strategyType = StrategyType.mirror,
            textColor = Color.White
        )
    }
}