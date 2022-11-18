package com.what3words.design.library.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val Grey90 = Color(0xFF1A1A1A)
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
val PastelGreen = Color(0xFF65D698)
val RipeLemon = Color(0xFFF6D31F)

class W3WColors(
    primary: Color,
    accent: Color,
    background: Color,
    backgroundSecondary: Color,
    backgroundHighlighted: Color,
    backgroundDisabled: Color,
    backgroundRipple: Color,
    backgroundError: Color,
    textPrimary: Color,
    textPlaceholder: Color,
    textError: Color,
    divider: Color,
    border: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var accent by mutableStateOf(accent)
        private set
    var background by mutableStateOf(background)
        private set
    var backgroundSecondary by mutableStateOf(backgroundSecondary)
        private set
    var backgroundHighlighted by mutableStateOf(backgroundHighlighted)
        private set
    var backgroundDisabled by mutableStateOf(backgroundDisabled)
        private set
    var backgroundRipple by mutableStateOf(backgroundRipple)
        private set
    var backgroundError by mutableStateOf(backgroundError)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textPlaceholder by mutableStateOf(textPlaceholder)
        private set
    var textError by mutableStateOf(textError)
        private set
    var divider by mutableStateOf(divider)
        private set
    var border by mutableStateOf(border)
        private set
    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        primary: Color = this.primary,
        accent: Color = this.accent,
        background: Color = this.background,
        backgroundSecondary: Color = this.backgroundSecondary,
        backgroundHighlighted: Color = this.backgroundHighlighted,
        backgroundDisabled: Color = this.backgroundDisabled,
        backgroundRipple: Color = this.backgroundRipple,
        backgroundError: Color = this.backgroundError,
        textPrimary: Color = this.textPrimary,
        textPlaceholder: Color = this.textPlaceholder,
        textError: Color = this.textError,
        divider: Color = this.divider,
        border: Color = this.border,
        isLight: Boolean = this.isLight
    ): W3WColors = W3WColors(
        primary,
        accent,
        background,
        backgroundSecondary,
        backgroundHighlighted,
        backgroundDisabled,
        backgroundRipple,
        backgroundError,
        textPrimary,
        textPlaceholder,
        textError,
        divider,
        border,
        isLight
    )

    fun updateColorsFrom(other: W3WColors) {
        primary = other.primary
        accent = other.accent
        background = other.background
        backgroundSecondary = other.backgroundSecondary
        backgroundHighlighted = other.backgroundHighlighted
        backgroundRipple = other.backgroundRipple
        backgroundError = other.backgroundError
        textPrimary = other.textPrimary
        textPlaceholder = other.textPlaceholder
        textError = other.textError
        divider = other.divider
        border = other.border
    }
}

fun lightColors(
    primary: Color = BlueWhale,
    accent: Color = Red,
    background: Color = White,
    backgroundSecondary: Color = Grey40,
    backgroundHighlighted: Color = BluePowder,
    backgroundDisabled: Color = Grey20,
    backgroundRipple: Color = Grey80,
    backgroundError: Color = BurntSienna,
    textPrimary: Color = Grey70,
    textPlaceholder: Color = Grey50,
    textError: Color = BlueWhale,
    divider: Color = Grey30,
    border: Color = Grey40
): W3WColors = W3WColors(
    primary = primary,
    accent = accent,
    background = background,
    backgroundSecondary = backgroundSecondary,
    backgroundHighlighted = backgroundHighlighted,
    backgroundDisabled = backgroundDisabled,
    backgroundRipple = backgroundRipple,
    backgroundError = backgroundError,
    textPrimary = textPrimary,
    textPlaceholder = textPlaceholder,
    textError = textError,
    divider = divider,
    border = border,
    isLight = true
)

fun darkColors(
    primary: Color = White,
    accent: Color = Red,
    background: Color = Grey90,
    backgroundSecondary: Color = Black,
    backgroundHighlighted: Color = BlueWhale,
    backgroundDisabled: Color = Black,
    backgroundRipple: Color = White,
    backgroundError: Color = BurntSienna,
    textPrimary: Color = Grey40,
    textPlaceholder: Color = Grey50,
    textError: Color = BlueWhale,
    divider: Color = Grey80,
    border: Color = Grey70
): W3WColors = W3WColors(
    primary = primary,
    accent = accent,
    background = background,
    backgroundSecondary = backgroundSecondary,
    backgroundHighlighted = backgroundHighlighted,
    backgroundDisabled = backgroundDisabled,
    backgroundRipple = backgroundRipple,
    backgroundError = backgroundError,
    textPrimary = textPrimary,
    textPlaceholder = textPlaceholder,
    textError = textError,
    divider = divider,
    border = border,
    isLight = false
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }