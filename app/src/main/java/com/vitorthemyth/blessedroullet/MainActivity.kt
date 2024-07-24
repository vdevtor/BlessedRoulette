package com.vitorthemyth.blessedroullet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vitorthemyth.blessedroullet.navigation.Routes
import com.vitorthemyth.blessedroullet.presenter.tracker.TrackerScreen
import com.vitorthemyth.blessedroullet.presenter.welcome.WelcomeScreen
import com.vitorthemyth.blessedroullet.ui.theme.AccentColor
import com.vitorthemyth.blessedroullet.ui.theme.BlessedRoulletTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BlessedRoulletTheme {
                val scaffoldState = rememberScaffoldState()
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                    snackbarHost = {
                        SnackbarHost(hostState = scaffoldState.snackbarHostState) {
                            Snackbar(
                                snackbarData = it,
                                backgroundColor = AccentColor,
                                contentColor = Color.White
                            )
                        }
                    }
                ) { paddingValues ->
                    paddingValues.toString()

                    NavHost(
                        navController = navController,
                        startDestination = Routes.WELCOME
                    ) {
                        composable(route = Routes.WELCOME) {
                            WelcomeScreen(
                                scaffoldState.snackbarHostState
                            ) {
                                navController.navigate(Routes.TRACKER)
                            }
                        }

                        composable(route = Routes.TRACKER) {
                            TrackerScreen()
                        }
                    }
                }
            }
        }
    }
}
