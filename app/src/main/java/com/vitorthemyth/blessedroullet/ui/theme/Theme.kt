package com.vitorthemyth.blessedroullet.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.vitorthemyth.blessedroullet.ui.values.Dimensions
import com.vitorthemyth.blessedroullet.ui.values.LocalSpacing
import com.vitorthemyth.blessedroullet.ui.values.LocalTextDimensions
import com.vitorthemyth.blessedroullet.ui.values.TextDimensions

private val LightColorScheme = lightColors(
    primary = BackgroundColor,
    onPrimary = onBackgroundColor,
    secondary = AccentColor
)

@Composable
fun BlessedRoulletTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current

    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.secondary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }

    CompositionLocalProvider(
        LocalSpacing provides(Dimensions()),
        LocalTextDimensions provides(TextDimensions()) ) {
        MaterialTheme(
            colors = colorScheme,
            typography = Typography,
            content = content
        )
    }
}