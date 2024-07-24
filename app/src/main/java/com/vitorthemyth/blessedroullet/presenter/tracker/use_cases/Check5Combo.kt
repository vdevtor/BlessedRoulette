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

class Check5Combo {
    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val triggerNumber = list.find { it.number == "5" } ?: return null
        val triggerIndex = list.indexOf(triggerNumber)
        val targetNumber = provideRouletteNumbers().find { it.number == "5" }
        val targetNumber2 = provideRouletteNumbers().find { it.number == "22" }
        val targetNumber3 = provideRouletteNumbers().find { it.number == "25" }


        val targetNumberNeighbors = targetNumber?.closestNeighbors ?: return null
        val targetNumberNeighbors2 = targetNumber2?.closestNeighbors ?: return null
        val targetNumberNeighbors3 = targetNumber3?.closestNeighbors ?: return null

        val newList = list.filterIndexed { index, _ ->
            index < triggerIndex
        }

        if (isStrategyExpired(
                targetNumberNeighbors,
                newList.map { it.number }) || isStrategyExpired(
                targetNumberNeighbors2,
                newList.map { it.number }) || isStrategyExpired(
                targetNumberNeighbors3,
                newList.map { it.number })
        ) {
            return null
        }

        val targetNumbersList = targetNumberNeighbors + targetNumberNeighbors2 + targetNumberNeighbors3

        val playableNumbers = provideRouletteNumbers().filter { it.number in targetNumbersList }

        return RouletteStrategy(
            strategyTitle = "Vizinhos do 5,22 e 5",
            strategyDescription = "Saiu o número 5 e ele é gatilho do número 5,22 e 25",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = lightBlack,
            strategyType = StrategyType.fiveCombo,
            textColor = yellowColor,
            tag = StrategyTag.premium
        )
    }
}