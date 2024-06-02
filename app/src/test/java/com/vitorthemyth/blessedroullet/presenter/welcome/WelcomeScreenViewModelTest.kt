package com.vitorthemyth.blessedroullet.presenter.welcome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.graphics.Color
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import com.vitorthemyth.blessedroullet.core.ui.UiEvent
import com.vitorthemyth.blessedroullet.presenter.welcome.model.Dozen
import com.vitorthemyth.blessedroullet.presenter.welcome.model.RouletteNumber
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class WelcomeScreenViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: WelcomeScreenViewModel
    private  val preferences: Preferences = mockk()

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    private val rouletteNumber = RouletteNumber(
        number = "22",
        color = Color.Red,
        isEven = false,
        dozen = Dozen.second,
        isHigherNumber = false
    )

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = WelcomeScreenViewModel(
            preferences = preferences
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verify WelcomeEvents OnNumberSelected is being performed`() = testScope.runTest{

        viewModel.onEvent(WelcomeEvents.OnNumberSelected(rouletteNumber))
        assertThat(viewModel.state.selectedNumbers.size).isEqualTo(1)
        assertThat(viewModel.state.selectedNumbers).contains(rouletteNumber)
    }

    @Test
    fun `verify WelcomeEvents OnNumberRemoved is being performed`() = testScope.runTest {

        viewModel.onEvent(WelcomeEvents.OnNumberSelected(rouletteNumber))
        assertThat(viewModel.state.selectedNumbers.size).isEqualTo(1)

        viewModel.onEvent(WelcomeEvents.OnNumberRemoved(rouletteNumber))
        assertThat(viewModel.state.selectedNumbers.size).isEqualTo(0)
        assertThat(viewModel.state.selectedNumbers).doesNotContain(rouletteNumber)

    }

    @Test
    fun `verify WelcomeEvents OnNextClicked saves selected numbers`() = testScope.runTest {
        coEvery { preferences.saveLastSortedNumbers(any()) } returns Unit

        viewModel.uiEvent.test {
            viewModel.onEvent(WelcomeEvents.OnNextClicked)
            coVerify { preferences.saveLastSortedNumbers(viewModel.state.selectedNumbers) }
            assertThat(awaitItem()).isEqualTo(UiEvent.NavigateUp)
        }
    }

    @Test
    fun `verify Snackbar event when more than 7 numbers are selected`() = testScope.runTest {

        viewModel.uiEvent.test {
            repeat(7) {
                viewModel.onEvent(WelcomeEvents.OnNumberSelected(rouletteNumber))
            }

            viewModel.onEvent(WelcomeEvents.OnNumberSelected(rouletteNumber))

            assertThat(awaitItem()).isEqualTo(UiEvent.ShowSnackBar("Você deve adicionar apenas 7 números"))
        }
    }
}
