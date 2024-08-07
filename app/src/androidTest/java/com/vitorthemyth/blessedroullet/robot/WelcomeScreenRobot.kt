package com.vitorthemyth.blessedroullet.robot

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.vitorthemyth.blessedroullet.MainActivity

typealias BlessedComposeRule = AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>

class WelcomeScreenRobot(
    private val composeRule: BlessedComposeRule
) {

    fun performScrollToLoadContent(number: String): WelcomeScreenRobot {
        composeRule
            .onNode(hasContentDescription("availableNumbersList"))
            .performScrollToNode(hasText(number))

        return this
    }

    fun clickOnNumber(number: String): WelcomeScreenRobot {
        composeRule
            .onNode(hasContentDescription("SelectNumberChip").and(hasText(number)))
            .performClick()
        return this
    }

    fun clickOnNumberToRemove(number: String): WelcomeScreenRobot {
        composeRule
            .onNode(hasContentDescription("SelectedNumberChip").and(hasText(number)))
            .performClick()
        return this
    }

    fun completeSelectedNumbers(): WelcomeScreenRobot {
        val listOfHighNumbers = listOf("33", "27", "30", "28", "31")
        listOfHighNumbers.forEach { clickOnNumber(it) }

        performScrollToLoadContent("1")

        val listOfLowNumbers = listOf("8", "5", "4", "2")
        listOfLowNumbers.forEach { clickOnNumber(it) }

        return this
    }

    fun assertNumberWasRemoved(number: String): WelcomeScreenRobot {
        composeRule
            .onNode(
                hasContentDescription("SelectedNumberChip")
                    .and(hasText(number))
            ).assertDoesNotExist()
        return this
    }

    fun assertThatButtonIsNotEnabled(): WelcomeScreenRobot {
        composeRule.onNodeWithText("Avançar")
            .assertIsNotEnabled()
        return this
    }

    fun assertThatButtonIsEnabled(): WelcomeScreenRobot {
        composeRule.onNodeWithText("Avançar")
            .assertIsEnabled()
        return this
    }
}
