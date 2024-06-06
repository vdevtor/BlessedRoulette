package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.PurpleColor

class CheckArcherStrategy {


    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val firstNumberPosition = list[0].rouletteQuarter.quarterOrder.position
        val secondNumberPosition = list[1].rouletteQuarter.quarterOrder.position
        val thirdNumberPosition = list[2].rouletteQuarter.quarterOrder.position

        val isValidSequence: Boolean = isValidThirdNumber(thirdNumberPosition, secondNumberPosition) &&
                isValidFirstNumberNumber(firstNumberPosition,thirdNumberPosition)

        if (!isValidSequence) return null

        val playableNumbers = provideRouletteNumbers().filter {
            it.rouletteQuarter.quarterOrder.position != firstNumberPosition
                    &&  it.rouletteQuarter.quarterOrder.position != secondNumberPosition
                    && it.rouletteQuarter.quarterOrder.position != thirdNumberPosition
        }

        return RouletteStrategy(
            strategyTitle = "Arco e Flecha",
            strategyDescription = "Os 3 últimos números cairam no quarto da roleta em sequencia, aposte nos numeros do quarto faltante.",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = PurpleColor,
            strategyType = StrategyType.archer,
            textColor = Color.White
        )
    }

    private fun isValidThirdNumber(thirdNumberPosition: Int, secondNumberPosition: Int) =
        if (thirdNumberPosition == 1) {
            secondNumberPosition == 4 || secondNumberPosition == 2
        } else if (thirdNumberPosition == 2) {
            secondNumberPosition == 1 || secondNumberPosition == 3
        } else if (thirdNumberPosition == 3) {
            secondNumberPosition == 2 || secondNumberPosition == 4
        } else if (thirdNumberPosition == 4) {
            secondNumberPosition == 1 || secondNumberPosition == 3
        } else false

    private fun isValidFirstNumberNumber(firstNumberPosition: Int, thirdNumberPosition: Int) =
        if (firstNumberPosition == 1) {
            thirdNumberPosition == 3
        } else if (firstNumberPosition == 2) {
            thirdNumberPosition == 4
        } else if (firstNumberPosition == 3) {
            thirdNumberPosition == 1
        } else if (firstNumberPosition == 4) {
            thirdNumberPosition == 2
        } else false
}