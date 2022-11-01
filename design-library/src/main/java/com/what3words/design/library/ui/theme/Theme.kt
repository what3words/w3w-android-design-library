package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object W3WTheme {
    val colors: W3WColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography: W3WTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val dimensions: W3WDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

@Composable
fun W3WTheme(
    colors: W3WColors = if (isSystemInDarkTheme()) darkColors() else lightColors(),
    typography: W3WTypography = W3WTheme.typography,
    dimensions: W3WDimensions = W3WTheme.dimensions,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography
    ) {
        content()
    }
}