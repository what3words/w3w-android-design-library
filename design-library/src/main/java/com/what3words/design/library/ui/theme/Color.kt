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
val WhiteOp16 = Color(0x69FFFFFF)
val Red = Color(0xFFE11F26)
val Tamarillo = Color(0xFFAB181D)
val BurntSienna = Color(0xFFF26C50)
val BlueWhale = Color(0xFF0A3049)
val BlueWhaleOp16 = Color(0x690A3049)
val BluePowder = Color(0xFFDBEFFA)
val BlueOrient = Color(0xFF005379)
val BlueOrientOp16 = Color(0x69005379)
val PastelGreen = Color(0xFF65D698)
val RipeLemon = Color(0xFFF6D31F)
val RegentStBlue = Color(0xFF98D5E5)
val Teal = Color(0xFFC2E1EB)
val TealOp10 = Color(0x69C2E1EB)

class W3WColors(
    primary: Color,
    accent: Color,
    background: Color,
    backgroundSecondary: Color,
    backgroundHighlighted: Color,
    backgroundDisabled: Color,
    backgroundRipple: Color,
    backgroundError: Color,
    backgroundWarning: Color,
    backgroundConfirmation: Color,
    backgroundInformation: Color,
    textPrimary: Color,
    textPlaceholder: Color,
    textNotification: Color,
    divider: Color,
    border: Color,
    buttonPrimary: Color,
    buttonPrimaryVariant: Color,
    onButtonPrimary: Color,
    buttonSecondary: Color,
    buttonSecondaryVariant: Color,
    onButtonSecondary: Color,
    buttonTertiary: Color,
    buttonTertiaryVariant: Color,
    onButtonTertiary: Color,
    buttonText: Color,
    buttonTextVariant: Color,
    onButtonText: Color,
    buttonOutline: Color,
    buttonOutlineVariant: Color,
    buttonOutlineBorder: Color,
    buttonOutlineBorderVariant: Color,
    onButtonOutline: Color,
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
    var backgroundWarning by mutableStateOf(backgroundWarning)
        private set
    var backgroundConfirmation by mutableStateOf(backgroundConfirmation)
        private set
    var backgroundInformation by mutableStateOf(backgroundInformation)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textPlaceholder by mutableStateOf(textPlaceholder)
        private set
    var textNotification by mutableStateOf(textNotification)
        private set
    var divider by mutableStateOf(divider)
        private set
    var border by mutableStateOf(border)
        private set

    //buttonPrimary
    var buttonPrimary by mutableStateOf(buttonPrimary)
        private set
    var buttonPrimaryVariant by mutableStateOf(buttonPrimaryVariant)
        private set
    var onButtonPrimary by mutableStateOf(onButtonPrimary)
        private set

    //buttonSecondary
    var buttonSecondary by mutableStateOf(buttonSecondary)
        private set
    var buttonSecondaryVariant by mutableStateOf(buttonSecondaryVariant)
        private set
    var onButtonSecondary by mutableStateOf(onButtonSecondary)
        private set

    //buttonTertiary
    var buttonTertiary by mutableStateOf(buttonTertiary)
        private set
    var buttonTertiaryVariant by mutableStateOf(buttonTertiaryVariant)
        private set
    var onButtonTertiary by mutableStateOf(onButtonTertiary)
        private set


    //buttonText
    var buttonText by mutableStateOf(buttonText)
        private set
    var buttonTextVariant by mutableStateOf(buttonTextVariant)
        private set
    var onButtonText by mutableStateOf(onButtonText)
        private set

    //buttonOutline
    var buttonOutline by mutableStateOf(buttonOutline)
        private set
    var buttonOutlineVariant by mutableStateOf(buttonOutlineVariant)
        private set
    var buttonOutlineBorder by mutableStateOf(buttonOutlineBorder)
        private set
    var buttonOutlineBorderVariant by mutableStateOf(buttonOutlineBorderVariant)
        private set
    var onButtonOutline by mutableStateOf(onButtonOutline)
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
        backgroundWarning: Color = this.backgroundWarning,
        backgroundConfirmation: Color = this.backgroundConfirmation,
        backgroundInformation: Color = this.backgroundInformation,
        textPrimary: Color = this.textPrimary,
        textPlaceholder: Color = this.textPlaceholder,
        textNotification: Color = this.textNotification,
        divider: Color = this.divider,
        border: Color = this.border,
        buttonPrimary: Color = this.buttonPrimary,
        buttonPrimaryVariant: Color = this.buttonPrimaryVariant,
        onButtonPrimary: Color = this.onButtonPrimary,
        buttonSecondary: Color = this.buttonSecondary,
        buttonSecondaryVariant: Color = this.buttonSecondaryVariant,
        onButtonSecondary: Color = this.onButtonSecondary,
        buttonTertiary: Color = this.buttonTertiary,
        buttonTertiaryVariant: Color = this.buttonTertiaryVariant,
        onButtonTertiary: Color = this.onButtonTertiary,
        buttonText: Color = this.buttonText,
        buttonTextVariant: Color = this.buttonTextVariant,
        onButtonText: Color = this.buttonTextVariant,
        buttonOutline: Color = this.buttonOutline,
        buttonOutlineVariant: Color = this.buttonTextVariant,
        buttonOutlineBorder: Color = this.buttonOutlineBorder,
        buttonOutlineBorderVariant: Color = this.buttonOutlineBorderVariant,
        onButtonOutline: Color = this.onButtonOutline,
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
        backgroundWarning,
        backgroundConfirmation,
        backgroundInformation,
        textPrimary,
        textPlaceholder,
        textNotification,
        divider,
        border,
        buttonPrimary,
        buttonPrimaryVariant,
        onButtonPrimary,
        buttonSecondary,
        buttonSecondaryVariant,
        onButtonSecondary,
        buttonTertiary,
        buttonTertiaryVariant,
        onButtonTertiary,
        buttonText,
        buttonTextVariant,
        onButtonText,
        buttonOutline,
        buttonOutlineVariant,
        buttonOutlineBorder,
        buttonOutlineBorderVariant,
        onButtonOutline,
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
        backgroundWarning = other.backgroundWarning
        backgroundConfirmation = other.backgroundConfirmation
        backgroundInformation = other.backgroundInformation
        textPrimary = other.textPrimary
        textPlaceholder = other.textPlaceholder
        textNotification = other.textNotification
        divider = other.divider
        buttonPrimary = other.buttonPrimary
        buttonPrimaryVariant = other.buttonPrimaryVariant
        onButtonPrimary = other.onButtonPrimary
        buttonSecondary = other.buttonSecondary
        buttonSecondaryVariant = other.buttonSecondaryVariant
        onButtonSecondary = other.onButtonSecondary
        buttonTertiary = other.buttonTertiary
        buttonTertiaryVariant = other.buttonTertiaryVariant
        onButtonTertiary = other.onButtonTertiary
        buttonText = other.buttonText
        buttonTextVariant = other.buttonTextVariant
        onButtonText = other.onButtonText
        buttonOutline = other.buttonOutline
        buttonOutlineVariant = other.buttonOutlineVariant
        buttonOutlineBorder = other.buttonOutlineBorder
        buttonOutlineBorderVariant = other.buttonOutlineBorderVariant
        onButtonOutline = other.onButtonOutline
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
    backgroundWarning: Color = RipeLemon,
    backgroundConfirmation: Color = PastelGreen,
    backgroundInformation: Color = RegentStBlue,
    textPrimary: Color = Grey70,
    textPlaceholder: Color = Grey50,
    textNotification: Color = BlueWhale,
    divider: Color = Grey30,
    border: Color = Grey40,
    buttonPrimary: Color = Red,
    buttonPrimaryVariant: Color = Tamarillo,
    onButtonPrimary: Color = White,
    buttonSecondary: Color = BlueWhale,
    buttonSecondaryVariant: Color = Black,
    onButtonSecondary: Color = White,
    buttonTertiary: Color = BlueOrient,
    buttonTertiaryVariant: Color = BlueWhale,
    onButtonTertiary: Color = White,
    buttonText: Color = Color.Transparent,
    buttonTextVariant: Color = BlueOrientOp16,
    onButtonText: Color = BlueWhale,
    buttonOutline: Color = White,
    buttonOutlineVariant: Color = BlueWhaleOp16,
    buttonOutlineBorder: Color = Grey30,
    buttonOutlineBorderVariant: Color = BlueWhale,
    onButtonOutline: Color = BlueWhale
): W3WColors = W3WColors(
    primary = primary,
    accent = accent,
    background = background,
    backgroundSecondary = backgroundSecondary,
    backgroundHighlighted = backgroundHighlighted,
    backgroundDisabled = backgroundDisabled,
    backgroundRipple = backgroundRipple,
    backgroundError = backgroundError,
    backgroundWarning = backgroundWarning,
    backgroundConfirmation = backgroundConfirmation,
    backgroundInformation = backgroundInformation,
    textPrimary = textPrimary,
    textPlaceholder = textPlaceholder,
    textNotification = textNotification,
    divider = divider,
    border = border,
    buttonPrimary = buttonPrimary,
    buttonPrimaryVariant = buttonPrimaryVariant,
    onButtonPrimary = onButtonPrimary,
    buttonSecondary = buttonSecondary,
    buttonSecondaryVariant = buttonSecondaryVariant,
    onButtonSecondary = onButtonSecondary,
    buttonTertiary = buttonTertiary,
    buttonTertiaryVariant = buttonTertiaryVariant,
    onButtonTertiary = onButtonTertiary,
    buttonText = buttonText,
    buttonTextVariant = buttonTextVariant,
    onButtonText = onButtonText,
    buttonOutline = buttonOutline,
    buttonOutlineVariant = buttonOutlineVariant,
    buttonOutlineBorder = buttonOutlineBorder,
    buttonOutlineBorderVariant = buttonOutlineBorderVariant,
    onButtonOutline = onButtonOutline,
    isLight = true
)

fun darkColors(
    primary: Color = White,
    accent: Color = Red,
    background: Color = Grey90,
    backgroundSecondary: Color = Black,
    backgroundHighlighted: Color = Grey80,
    backgroundDisabled: Color = Black,
    backgroundRipple: Color = White,
    backgroundError: Color = BurntSienna,
    backgroundWarning: Color = RipeLemon,
    backgroundConfirmation: Color = PastelGreen,
    backgroundInformation: Color = RegentStBlue,
    textPrimary: Color = Grey40,
    textPlaceholder: Color = Grey50,
    textNotification: Color = BlueWhale,
    divider: Color = Grey80,
    border: Color = Grey70,
    buttonPrimary: Color = Red,
    buttonPrimaryVariant: Color = Tamarillo,
    onButtonPrimary: Color = White,
    buttonSecondary: Color = Teal,
    buttonSecondaryVariant: Color = TealOp10,
    onButtonSecondary: Color = BlueWhale,
    buttonTertiary: Color = BlueOrient,
    buttonTertiaryVariant: Color = BlueWhale,
    onButtonTertiary: Color = White,
    buttonText: Color = Color.Transparent,
    buttonTextVariant: Color = WhiteOp16,
    onButtonText: Color = White,
    buttonOutline: Color = Black,
    buttonOutlineVariant: Color = Black,
    buttonOutlineBorder: Color = Grey30,
    buttonOutlineBorderVariant: Color = White,
    onButtonOutline: Color = White
): W3WColors = W3WColors(
    primary = primary,
    accent = accent,
    background = background,
    backgroundSecondary = backgroundSecondary,
    backgroundHighlighted = backgroundHighlighted,
    backgroundDisabled = backgroundDisabled,
    backgroundRipple = backgroundRipple,
    backgroundError = backgroundError,
    backgroundWarning = backgroundWarning,
    backgroundConfirmation = backgroundConfirmation,
    backgroundInformation = backgroundInformation,
    textPrimary = textPrimary,
    textPlaceholder = textPlaceholder,
    textNotification = textNotification,
    divider = divider,
    border = border,
    buttonPrimary = buttonPrimary,
    buttonPrimaryVariant = buttonPrimaryVariant,
    onButtonPrimary = onButtonPrimary,
    buttonSecondary = buttonSecondary,
    buttonSecondaryVariant = buttonSecondaryVariant,
    onButtonSecondary = onButtonSecondary,
    buttonTertiary = buttonTertiary,
    buttonTertiaryVariant = buttonTertiaryVariant,
    onButtonTertiary = onButtonTertiary,
    buttonText = buttonText,
    buttonTextVariant = buttonTextVariant,
    onButtonText = onButtonText,
    buttonOutline = buttonOutline,
    buttonOutlineVariant = buttonOutlineVariant,
    buttonOutlineBorder = buttonOutlineBorder,
    buttonOutlineBorderVariant = buttonOutlineBorderVariant,
    onButtonOutline = onButtonOutline,
    isLight = false
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }