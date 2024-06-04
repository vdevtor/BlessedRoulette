package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.RedColor

class CheckFerrariStrategy {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val firstNumber = list[0]
        val secondNumber = list[1]

        val isInTheSameDozen = firstNumber.dozen == secondNumber.dozen
        if (!isInTheSameDozen) return null


        val leftNeighbor = (firstNumber.number.toInt() -1).toString()
        val rightNeighbor = (firstNumber.number.toInt() +1).toString()

        val filteredList = provideRouletteNumbers().filter {
            it.number == leftNeighbor || it.number == rightNeighbor
        }.let {
            it.flatMap { it.closestNeighbors }
        }

        val playableNumbers = provideRouletteNumbers().filter {
                filteredList.contains(it.number)
        }


        return RouletteStrategy(
            strategyTitle = "Ferrari",
            strategyDescription = "Os 2 últimos numeros cairam na mesma duzia, selecione o modo pista para pegar vizinho da esquerda e da direita",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.second,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = RedColor,
            strategyType = StrategyType.ferrari,
            textColor = Color.White
        )
    }
}