package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.BrownColor

class CheckBugattiStrategy {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val firstNumberPositionTerminal = list[0].number.toCharArray().last()
        val secondNumberPositionTerminal = list[1].number.toCharArray().last()

        if (firstNumberPositionTerminal.toString().toInt() >= secondNumberPositionTerminal.toString().toInt()) {
            return null
        }

        val terminal1 = (firstNumberPositionTerminal.toString().toInt() + 1).toString()
        val terminal2 = (firstNumberPositionTerminal.toString().toInt() + 2).toString()

        val playableNumbers = provideRouletteNumbers().filter {
            it.number.toCharArray().last() == terminal1.toCharArray().last() ||
                it.number.toCharArray().last() == terminal2.toCharArray().last()
        }

        return RouletteStrategy(
            strategyTitle = "Bugatti",
            strategyDescription = "O último número possui terminal menor que o penultimo, escolha os terminas do ultimo numero +1 e +2 ",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = BrownColor,
            strategyType = StrategyType.bugatti,
            textColor = Color.White
        )
    }
}