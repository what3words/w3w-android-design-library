package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

/**
 * A composable function that applies the What3words theme to its content.
 * This theme is an extension of the MaterialTheme with customized colors and typography
 * specific to the What3words design system. It supports both light and dark theme modes.
 *
 * @param useDarkTheme A boolean value to specify if the dark theme should be used.
 *                     By default, it's set based on the system's theme preference.
 * @param content A composable lambda which will be the content of this theme. All composable
 *                functions inside this lambda will inherit the What3words theme.
 */
@Composable
fun W3WTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Choose the appropriate color scheme based on the theme preference.
    val colorScheme = if (useDarkTheme)
        w3wDarkColors
    else w3wLightColors

    // Customize typography for the What3words theme.
    val w3wTypography = W3wTypography(
        titleMediumProminent = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(17f, TextUnitType.Sp)
        ),
        labelMediumProminent = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Bold
        ),
        labelLargeProminent = MaterialTheme.typography.labelLarge.copy(
            fontWeight = FontWeight.Bold
        )
    )

    // Provide the What3words typography to the MaterialTheme.
    CompositionLocalProvider(
        LocalW3wTypography provides w3wTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}