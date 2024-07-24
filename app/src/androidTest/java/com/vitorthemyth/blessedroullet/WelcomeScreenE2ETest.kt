package com.vitorthemyth.blessedroullet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.vitorthemyth.blessedroullet.robot.WelcomeScreenRobot
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class WelcomeScreenE2ETest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testSelectableNumbers() {
        WelcomeScreenRobot(composeRule)
            .performScrollToLoadContent("33")
            .clickOnNumber("28")
            .clickOnNumber("29")
            .clickOnNumber("30")
            .assertThatButtonIsNotEnabled()
            .clickOnNumberToRemove("30")
            .assertNumberWasRemoved("30")
            .completeSelectedNumbers()
            .assertThatButtonIsEnabled()
    }
}
