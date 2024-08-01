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

class Check35Combo {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {
        if (list.size < 2) return null

        val triggerNumber = list.find { it.number == "35" } ?: return null
        val triggerIndex = list.indexOf(triggerNumber)
        val targetNumber = provideRouletteNumbers().find { it.number == "26" }
        val targetNumber2 = provideRouletteNumbers().find { it.number == "33" }
        val targetNumber3 = provideRouletteNumbers().find { it.number == "13" }

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
            strategyTitle = "V:26 & 33 & 13 - G:35",
            strategyDescription = "Saiu o número 35 e ele é gatilho do número 26,33 e 13",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = lightBlack,
            strategyType = StrategyType.thrityFiveCombo,
            textColor = yellowColor,
            tag = StrategyTag.premium
        )
    }
}