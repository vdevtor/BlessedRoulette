package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.BlueColor
import com.vitorthemyth.blessedroullet.ui.theme.RedColor

class CheckOneByOneStrategy {

    operator fun invoke(list: List<RouletteNumber>) : RouletteStrategy?{
        if (list.size < 2) return null

        val firstNumber = list[0]
        val secondNumber = list[1]

        val hasTermination = secondNumber.number.contains(firstNumber.number.last())

        if (!hasTermination) return null

        val leftNeighbor = (firstNumber.number.toInt() -1).toString()
        val rightNeighbor = (firstNumber.number.toInt() +1).toString()

        val playableNumbers = provideRouletteNumbers().filter {
            it.number.last() == leftNeighbor.last() || it.number.last() == rightNeighbor.last()
        }


        return RouletteStrategy(
            strategyTitle = "1 por 1",
            strategyDescription = "Os 2 últimos numeros tem a mesma terminação,selecione os numeros com terminais iguais aos vizinhos do ultimo numero selecionado",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = BlueColor,
            strategyType = StrategyType.oneByOne,
            textColor = Color.Black
        )
    }
}