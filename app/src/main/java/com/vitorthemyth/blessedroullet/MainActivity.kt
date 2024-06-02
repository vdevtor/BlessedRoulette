package com.vitorthemyth.blessedroullet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vitorthemyth.blessedroullet.presenter.welcome.WelcomeScreen
import com.vitorthemyth.blessedroullet.ui.theme.BlessedRoulletTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) {paddingValues ->
                paddingValues.toString()
                BlessedRoulletTheme {
                    WelcomeScreen {

                    }
                }
            }
        }
    }
}
