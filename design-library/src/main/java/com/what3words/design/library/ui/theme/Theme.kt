package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val W3WDarkColorPalette = darkColors(
    primary = White,
    primaryVariant = Red,
    secondary = BlueWhale,
    background = Blue90
)

private val W3WLightColorPalette = lightColors(
    primary = BlueWhale,
    primaryVariant = Red,
    secondary = BluePowder,
    background = White
)

@Composable
fun W3WTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        W3WDarkColorPalette
    } else {
        W3WLightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}