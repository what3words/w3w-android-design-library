package com.what3words.design.library.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class W3WDimensions(
    val paddingTiny: Dp = 4.dp,
    val paddingSmall: Dp = 8.dp,
    val paddingMedium: Dp = 12.dp,
    val paddingLarge: Dp = 16.dp
)

internal val LocalDimensions = staticCompositionLocalOf { W3WDimensions() }