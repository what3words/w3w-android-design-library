package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.google.accompanist.systemuicontroller.rememberSystemUiController


/**
 * A composable function that applies the What3words theme to its content.
 * This theme is an extension of the MaterialTheme with customized colors and typography
 * specific to the What3words design system. It supports both light and dark theme modes.
 *
 * @param useDarkTheme A boolean value to specify if the dark theme should be used.
 *                     By default, it's set based on the system's theme preference.
 * @param colorScheme The color scheme to be used. Default is set based on the theme preference.
 * @param w3WColorScheme The What3words color scheme to be used. Default is set based on the theme preference.
 * @param typography The typography to be used. Default is set by [MaterialTheme.typography].
 * @param w3wTypography The What3words typography to be used. Default is set with custom configurations.
 * @param setStatusBarColor A composable lambda function to set the status bar color. If null, the status bar color is set by [MaterialTheme.colorScheme.secondaryContainer].
 * @param setNavigationBarColor A composable lambda function to set the navigation bar color. If null, the navigation bar color is set by [MaterialTheme.surfaceVariationsColors.surfaceContainerLow].
 * @param content A composable lambda which will be the content of this theme. All composable
 *                functions inside this lambda will inherit the What3words theme.
 */
@Composable
fun W3WTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    colorScheme: ColorScheme = if (useDarkTheme) w3wDarkColors else w3wLightColors,
    w3WColorScheme: W3WColorScheme = if (useDarkTheme) w3wDarkW3WSchemeColors else w3wLightW3WSchemeColors,
    typography: Typography = MaterialTheme.typography,
    w3wTypography: W3wTypography = W3wTypography(
        displayMediumMedium = MaterialTheme.typography.displayMedium.copy(
            fontWeight = FontWeight.Medium,
        ),
        headlineLargeSemibold = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.SemiBold,
            letterSpacing = TextUnit(-0.1f, TextUnitType.Sp)
        ),
        titleLargeSemibold = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold,
            letterSpacing = TextUnit(-0.1f, TextUnitType.Sp)
        ),
        titleMediumSemibold = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(17f, TextUnitType.Sp)
        ),
        labelMediumBold = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Bold
        ),
        labelLargeBold = MaterialTheme.typography.labelLarge.copy(
            fontWeight = FontWeight.Bold
        )
    ),
    setStatusBarColor: (@Composable () -> Unit)? = null,
    setNavigationBarColor: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    // Provide the What3words typography to the MaterialTheme.
    CompositionLocalProvider(
        LocalW3wTypography provides w3wTypography,
        LocalW3WColorScheme provides w3WColorScheme,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
        ) {
            //to be removed and use non-accompanist way to do this when updated to SDK 34
            val systemUiController = rememberSystemUiController()
            if (setStatusBarColor != null) setStatusBarColor()
            else {
                systemUiController.setStatusBarColor(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
            }
            if (setNavigationBarColor != null) setNavigationBarColor()
            else {
                systemUiController.setNavigationBarColor(MaterialTheme.colorScheme.surfaceContainerLow)
            }
            content()
        }
    }
}