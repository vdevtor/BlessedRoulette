package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

import com.vitorthemyth.blessedroullet.core.provider.isStrategyExpired
import com.vitorthemyth.blessedroullet.core.provider.provideRouletteNumbers
import com.vitorthemyth.blessedroullet.presenter.tracker.model.RouletteStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyTag
import com.vitorthemyth.blessedroullet.presenter.tracker.model.StrategyType
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import com.vitorthemyth.blessedroullet.ui.theme.lightBlack
import com.vitorthemyth.blessedroullet.ui.theme.yellowColor

class Check13AndNeighbors {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val triggerNumber = list.find { it.number == "33" } ?: return null
        val triggerIndex = list.indexOf(triggerNumber)
        val targetNumber = provideRouletteNumbers().find { it.number == "13" }
        val targetNumberNeighbors = targetNumber?.closestNeighbors ?: return null

        val newList = list.filterIndexed { index, _ ->
            index < triggerIndex
        }

        if (isStrategyExpired(targetNumberNeighbors, newList.map { it.number })) {
            return null
        }

        val playableNumbers = provideRouletteNumbers().filter { it.number in targetNumberNeighbors }

        return RouletteStrategy(
            strategyTitle = "V:13 - G:33",
            strategyDescription = "Saiu o número 33 e ele é gatilho do número 13 e vizinhos",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = lightBlack,
            strategyType = StrategyType.thirteenAndNeighbors,
            textColor = yellowColor,
            tag = StrategyTag.premium
        )
    }
}