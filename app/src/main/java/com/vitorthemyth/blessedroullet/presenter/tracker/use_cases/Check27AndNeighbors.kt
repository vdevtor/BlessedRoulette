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

class Check27AndNeighbors {

    operator fun invoke(list: List<RouletteNumber>): RouletteStrategy? {

        if (list.size < 2) return null
        val triggerNumber = list.find { it.number == "19" } ?: return null
        val triggerIndex = list.indexOf(triggerNumber)
        val targetNumber = provideRouletteNumbers().find { it.number == "27" }


        val targetNumberNeighbors = targetNumber?.closestNeighbors.orEmpty()

        if (targetNumberNeighbors.isEmpty()) {
            return null
        }

        val newList = list.filterIndexed { index, _ ->
            index < triggerIndex
        }

        if (isStrategyExpired(targetNumberNeighbors,newList.map { it.number })) {
            return null
        }

        val playableNumbers = provideRouletteNumbers().filter { it.number in targetNumberNeighbors }

        return RouletteStrategy(
            strategyTitle = "27 & Vizinhos",
            strategyDescription = "Saiu o número 19 e ele é gatilho do número 27",
            playableNumbers = playableNumbers,
            playableDozen = Dozen.none,
            placeBetOnHighNumber = false,
            placeBetOnLowNumber = false,
            cardBackGroundColor = lightBlack,
            strategyType = StrategyType.twentySevenAndNeighbors,
            textColor = yellowColor,
            tag = StrategyTag.premium
        )
    }
}
