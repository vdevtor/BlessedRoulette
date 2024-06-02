package com.vitorthemyth.blessedroullet.robot

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
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
            .onNodeWithText(number)
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
        val listOfNumbers = listOf("11", "9", "34", "14")
        listOfNumbers.forEach { clickOnNumber(it) }
        performScrollToLoadContent("1")
        clickOnNumber("5")
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