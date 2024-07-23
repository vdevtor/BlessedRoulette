package com.vitorthemyth.blessedroullet.core.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vitorthemyth.blessedroullet.ui.theme.PurpleColor

@Composable
fun DefaultFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = PurpleColor,
        contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add new Number")
    }
}