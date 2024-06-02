package com.vitorthemyth.blessedroullet.ui.values

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class TextDimensions(
    val default: TextUnit = 14.sp,
    val textExtraSmall: TextUnit = 10.sp,
    val textSmall: TextUnit = 12.sp,
    val textMedium: TextUnit = 18.sp,
    val textLarge: TextUnit = 24.sp,
    val textExtraLarge: TextUnit = 32.sp
)

val LocalTextDimensions = compositionLocalOf { TextDimensions() }