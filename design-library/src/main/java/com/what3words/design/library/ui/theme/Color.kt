package com.what3words.design.library.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val Grey80 = Color(0xFF32373C)
val Grey70 = Color(0xFF525252)
val Grey60 = Color(0xFF616161)
val Grey50 = Color(0xFF999999)
val Grey45 = Color(0xFFA3A3A3)
val Grey40 = Color(0xFFBFBFBF)
val Grey30 = Color(0xFFD6D6D6)
val Grey20 = Color(0xFFEBEBEB)
val Grey10 = Color(0xFFF2F4F5)
val White = Color(0xFFFFFFFF)
val Rust = Color(0xFFB24000)
val Red = Color(0xFFE11F26)
val BurntSienna = Color(0xFFF26C50)
val Blue90 = Color(0xFF001526)
val BlueWhale = Color(0xFF0A3049)
val BluePowder = Color(0xFFDBEFFA)
val SilverTree = Color(0xFF65D698)

class W3WColors(
    primary: Color,
    accent: Color,
    background: Color,
    backgroundHighlighted: Color,
    backgroundDisabled: Color,
    backgroundRipple: Color,
    textPrimary: Color,
    textSecondary: Color,
    textFootnote: Color,
    backgroundError: Color,
    textError: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var accent by mutableStateOf(accent)
        private set
    var background by mutableStateOf(background)
        private set
    var backgroundHighlighted by mutableStateOf(backgroundHighlighted)
        private set
    var backgroundDisabled by mutableStateOf(backgroundDisabled)
        private set
    var backgroundRipple by mutableStateOf(backgroundRipple)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textFootnote by mutableStateOf(textFootnote)
        private set
    var backgroundError by mutableStateOf(backgroundError)
        private set
    var textError by mutableStateOf(textError)
        private set
    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        primary: Color = this.primary,
        accent: Color = this.accent,
        background: Color = this.background,
        backgroundHighlighted: Color = this.backgroundHighlighted,
        backgroundDisabled: Color = this.backgroundDisabled,
        backgroundRipple: Color = this.backgroundRipple,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        textFootnote: Color = this.textFootnote,
        backgroundError: Color = this.backgroundError,
        textError: Color = this.textError,
        isLight: Boolean = this.isLight
    ): W3WColors = W3WColors(
        primary,
        accent,
        background,
        backgroundHighlighted,
        backgroundDisabled,
        backgroundRipple,
        textPrimary,
        textSecondary,
        textFootnote,
        backgroundError,
        textError,
        isLight
    )

    fun updateColorsFrom(other: W3WColors) {
        primary = other.primary
        accent = other.accent
        background = other.background
        backgroundHighlighted = other.backgroundHighlighted
        backgroundRipple = other.backgroundRipple
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textFootnote = other.textFootnote
        backgroundError = other.backgroundError
        textError = other.textError
    }
}

fun lightColors(
    primary: Color = BlueWhale,
    accent: Color = Red,
    background: Color = White,
    backgroundHighlighted: Color = BluePowder,
    backgroundDisabled: Color = Grey20,
    backgroundRipple: Color = Grey80,
    textPrimary: Color = Grey80,
    textSecondary: Color = Grey70,
    textFootnote: Color = Grey70,
    backgroundError: Color = White,
    textError: Color = Rust
): W3WColors = W3WColors(
    primary = primary,
    accent = accent,
    background = background,
    backgroundHighlighted = backgroundHighlighted,
    backgroundDisabled = backgroundDisabled,
    backgroundRipple = backgroundRipple,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    textFootnote = textFootnote,
    backgroundError = backgroundError,
    textError = textError,
    isLight = true
)

fun darkColors(
    primary: Color = White,
    accent: Color = Red,
    background: Color = Blue90,
    backgroundHighlighted: Color = BlueWhale,
    backgroundDisabled: Color = Blue90,
    backgroundRipple: Color = Grey10,
    textPrimary: Color = White,
    textSecondary: Color = White,
    textFootnote: Color = Grey40,
    backgroundError: Color = BurntSienna,
    textError: Color = Blue90
): W3WColors = W3WColors(
    primary = primary,
    accent = accent,
    background = background,
    backgroundHighlighted = backgroundHighlighted,
    backgroundDisabled = backgroundDisabled,
    backgroundRipple = backgroundRipple,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    textFootnote = textFootnote,
    backgroundError = backgroundError,
    textError = textError,
    isLight = true
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }