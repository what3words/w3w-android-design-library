package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

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


class W3WColors(
    primary: Color,
    background: Color,
    backgroundHighlighted: Color,
    textPrimary: Color,
    textSecondary: Color,
    textFootnote: Color,
    textAccent: Color,
    backgroundError: Color,
    textError: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var background by mutableStateOf(background)
        private set
    var backgroundHighlighted by mutableStateOf(backgroundHighlighted)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textFootnote by mutableStateOf(textFootnote)
        private set
    var textAccent by mutableStateOf(textAccent)
        private set
    var backgroundError by mutableStateOf(backgroundError)
        private set
    var textError by mutableStateOf(textError)
        private set
    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        primary: Color = this.primary,
        background: Color = this.background,
        highlightedBackground: Color = this.backgroundHighlighted,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        textFootnote: Color = this.textFootnote,
        textAccent: Color = this.textAccent,
        backgroundError: Color = this.backgroundError,
        textError: Color = this.textError,
        isLight: Boolean = this.isLight
    ): W3WColors = W3WColors(
        primary,
        background,
        highlightedBackground,
        textPrimary,
        textSecondary,
        textFootnote,
        textAccent,
        backgroundError,
        textError,
        isLight
    )

    fun updateColorsFrom(other: W3WColors) {
        primary = other.primary
        background = other.background
        backgroundHighlighted = other.backgroundHighlighted
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textFootnote = other.textFootnote
        textAccent = other.textAccent
        backgroundError = other.backgroundError
        textError = other.textError
    }
}

fun lightColors(
    primary: Color = BlueWhale,
    background: Color = White,
    highlightedBackground: Color = BluePowder,
    textPrimary: Color = BlueWhale,
    textSecondary: Color = Grey70,
    textFootnote: Color = Grey70,
    textAccent: Color = Red,
    backgroundError: Color = White,
    textError: Color = Rust
): W3WColors = W3WColors(
    primary = primary,
    background = background,
    backgroundHighlighted = highlightedBackground,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    textFootnote = textFootnote,
    textAccent = textAccent,
    backgroundError = backgroundError,
    textError = textError,
    isLight = true
)

fun darkColors(
    primary: Color = White,
    background: Color = Blue90,
    highlightedBackground: Color = BlueWhale,
    textPrimary: Color = White,
    textSecondary: Color = White,
    textFootnote: Color = Grey40,
    textAccent: Color = Red,
    backgroundError: Color = BurntSienna,
    textError: Color = Blue90
): W3WColors = W3WColors(
    primary = primary,
    background = background,
    backgroundHighlighted = highlightedBackground,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    textFootnote = textFootnote,
    textAccent = textAccent,
    backgroundError = backgroundError,
    textError = textError,
    isLight = true
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }

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