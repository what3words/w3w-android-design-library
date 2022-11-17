package com.what3words.design.library.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class W3WDimensions(
    val paddingTiny: Dp = 4.dp,
    val paddingSmall: Dp = 8.dp,
    val paddingMedium: Dp = 12.dp,
    val paddingLarge: Dp = 16.dp,
    val paddingXLarge: Dp = 20.dp,
    val paddingXXLarge: Dp = 24.dp,
    val borderThickness: Dp = 1.dp,
    val borderRadius: Dp = 4.dp,
    val divider: Dp = 1.dp,
    val appBarElevation: Dp = 15.dp
)

internal val LocalDimensions = staticCompositionLocalOf { W3WDimensions() }