package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

//primary
val w3w_theme_light_primary = Color(0xFFC00004)
val w3w_theme_light_onPrimary = Color(0xFFFFFFFF)
val w3w_theme_light_primaryContainer = Color(0xFFFFCAC2)
val w3w_theme_light_onPrimaryContainer = Color(0xFF410000)

val w3w_theme_dark_primary = Color(0xFFFFB4A9)
val w3w_theme_dark_onPrimary = Color(0xFF690001)
val w3w_theme_dark_primaryContainer = Color(0xFF930002)
val w3w_theme_dark_onPrimaryContainer = Color(0xFFFFCAC2)

//secondary
val w3w_theme_light_secondary = Color(0xFF006397)
val w3w_theme_light_onSecondary = Color(0xFFFFFFFF)
val w3w_theme_light_secondaryContainer = Color(0xFFDBEFFA)
val w3w_theme_light_onSecondaryContainer = Color(0xFF001D31)

val w3w_theme_dark_secondary = Color(0xFFC2E1EB)
val w3w_theme_dark_onSecondary = Color(0xFF0A3049)
val w3w_theme_dark_secondaryContainer = Color(0xFF005379)
val w3w_theme_dark_onSecondaryContainer = Color(0xFFDBEFFA)

//error
val w3w_theme_light_error = Color(0xFFF26C50)
val w3w_theme_light_errorContainer = Color(0xFFFFDAD3)
val w3w_theme_light_onError = Color(0xFFFFFFFF)
val w3w_theme_light_onErrorContainer = Color(0xFF640D00)

val w3w_theme_dark_error = Color(0xFFFFB4A4)
val w3w_theme_dark_errorContainer = Color(0xFFCA4F36)
val w3w_theme_dark_onError = Color(0xFF640D00)
val w3w_theme_dark_onErrorContainer = Color(0xFFFFDAD3)

//warning (what3words custom)
val w3w_theme_light_warning = Color(0xFFC7AA00)
val w3w_theme_light_warningContainer = Color(0xFFFFF4B2)
val w3w_theme_light_onWarning = Color(0xFFFFFFFF)
val w3w_theme_light_onWarningContainer = Color(0xFF6F5D00)

val w3w_theme_dark_warning = Color(0xFFFFEC8A)
val w3w_theme_dark_warningContainer = Color(0xFFC7AA00)
val w3w_theme_dark_onWarning = Color(0xFF6F5D00)
val w3w_theme_dark_onWarningContainer = Color(0xFFFFF4B2)

//success (what3words custom)
val w3w_theme_light_success = Color(0xFF008857)
val w3w_theme_light_successContainer = Color(0xFF8BF8BD)
val w3w_theme_light_onSuccess = Color(0xFFFFFFFF)
val w3w_theme_light_onSuccessContainer = Color(0xFF003822)

val w3w_theme_dark_success = Color(0xFF6ECB9C)
val w3w_theme_dark_successContainer = Color(0xFF006C45)
val w3w_theme_dark_onSuccess = Color(0xFF003822)
val w3w_theme_dark_onSuccessContainer = Color(0xFF8BF8BD)

//surface
val w3w_theme_light_surface = Color(0xFFFBFDF9)
val w3w_theme_light_onSurface = Color(0xFF191C1A)
val w3w_theme_light_surfaceVariant = Color(0xFFEBEBEB) //missing map
val w3w_theme_light_onSurfaceVariant = Color(0xFF32373C)
val w3w_theme_light_surfaceBright = Color(0xFFFCFCFF)
val w3w_theme_light_surfaceDim = Color(0xFFD9DADD)
val w3w_theme_light_surfaceContainer = Color(0xFFEDEEF0)
val w3w_theme_light_surfaceContainerHigh = Color(0xFFE2E2E5)
val w3w_theme_light_surfaceContainerLow = Color(0xFFF3F3F6)
val w3w_theme_light_surfaceContainerHighest = Color(0xFFE2E2E5)
val w3w_theme_light_surfaceContainerLowest = Color(0xFFFFFFFF)


val w3w_theme_dark_surface = Color(0xFF111416)
val w3w_theme_dark_onSurface = Color(0xFFE2E2E5)
val w3w_theme_dark_surfaceVariant = Color(0xFF32373C)
val w3w_theme_dark_onSurfaceVariant = Color(0xFFD6D6D6)
val w3w_theme_dark_surfaceBright = Color(0xFF37393C)
val w3w_theme_dark_surfaceDim = Color(0xFF111416)
val w3w_theme_dark_surfaceContainer = Color(0xFF1E2022)
val w3w_theme_dark_surfaceContainerHigh = Color(0xFF282A2D)
val w3w_theme_dark_surfaceContainerLow = Color(0xFF1A1C1E)
val w3w_theme_dark_surfaceContainerHighest = Color(0xFF333537)
val w3w_theme_dark_surfaceContainerLowest = Color(0xFF0C0E11)

//background
val w3w_theme_light_background = Color(0xFFFFFBFF)
val w3w_theme_light_onBackground = Color(0xFF1A1C1E)

val w3w_theme_dark_background = Color(0xFF1A1C1E)
val w3w_theme_dark_onBackground = Color(0xFFE2E2E5)

//misc
val w3w_theme_light_outline = Color(0xFFEBEBEB)
val w3w_theme_light_inverseOnSurface = Color(0xFFF0F0F3)
val w3w_theme_light_inverseSurface = Color(0xFF2E3133)
val w3w_theme_light_inversePrimary = Color(0xFFFFB4A9)
val w3w_theme_light_shadow = Color(0xFF000000) //not in lib
val w3w_theme_light_outlineVariant = Color(0xFFF2F4F5)
val w3w_theme_light_scrim = Color(0xFF000000)

val w3w_theme_dark_outline = Color(0xFF141D1F)
val w3w_theme_dark_inverseOnSurface = Color(0xFF2E3133)
val w3w_theme_dark_inverseSurface = Color(0xFFE2E2E5)
val w3w_theme_dark_inversePrimary = Color(0xFFC00004)
val w3w_theme_dark_shadow = Color(0xFF000000) //not in lib
val w3w_theme_dark_outlineVariant = Color(0xFF32373C)
val w3w_theme_dark_scrim = Color(0xFF000000)

internal val w3wLightColors = lightColorScheme(
    primary = w3w_theme_light_primary,
    onPrimary = w3w_theme_light_onPrimary,
    primaryContainer = w3w_theme_light_primaryContainer,
    onPrimaryContainer = w3w_theme_light_onPrimaryContainer,
    secondary = w3w_theme_light_secondary,
    onSecondary = w3w_theme_light_onSecondary,
    secondaryContainer = w3w_theme_light_secondaryContainer,
    onSecondaryContainer = w3w_theme_light_onSecondaryContainer,
    error = w3w_theme_light_error,
    errorContainer = w3w_theme_light_errorContainer,
    onError = w3w_theme_light_onError,
    onErrorContainer = w3w_theme_light_onErrorContainer,
    background = w3w_theme_light_background,
    onBackground = w3w_theme_light_onBackground,
    surface = w3w_theme_light_surface,
    onSurface = w3w_theme_light_onSurface,
    surfaceVariant = w3w_theme_light_surfaceVariant,
    onSurfaceVariant = w3w_theme_light_onSurfaceVariant,
    outline = w3w_theme_light_outline,
    inverseOnSurface = w3w_theme_light_inverseOnSurface,
    inverseSurface = w3w_theme_light_inverseSurface,
    inversePrimary = w3w_theme_light_inversePrimary,
    outlineVariant = w3w_theme_light_outlineVariant,
    scrim = w3w_theme_light_scrim,
    surfaceBright = w3w_theme_light_surfaceBright,
    surfaceDim = w3w_theme_light_surfaceDim,
    surfaceContainer = w3w_theme_light_surfaceContainer,
    surfaceContainerHigh = w3w_theme_light_surfaceContainerHigh,
    surfaceContainerLow = w3w_theme_light_surfaceContainerLow,
    surfaceContainerHighest = w3w_theme_light_surfaceContainerHighest,
    surfaceContainerLowest = w3w_theme_light_surfaceContainerLowest
)

internal val w3wDarkColors = darkColorScheme(
    primary = w3w_theme_dark_primary,
    onPrimary = w3w_theme_dark_onPrimary,
    primaryContainer = w3w_theme_dark_primaryContainer,
    onPrimaryContainer = w3w_theme_dark_onPrimaryContainer,
    secondary = w3w_theme_dark_secondary,
    onSecondary = w3w_theme_dark_onSecondary,
    secondaryContainer = w3w_theme_dark_secondaryContainer,
    onSecondaryContainer = w3w_theme_dark_onSecondaryContainer,
    error = w3w_theme_dark_error,
    errorContainer = w3w_theme_dark_errorContainer,
    onError = w3w_theme_dark_onError,
    onErrorContainer = w3w_theme_dark_onErrorContainer,
    background = w3w_theme_dark_background,
    onBackground = w3w_theme_dark_onBackground,
    surface = w3w_theme_dark_surface,
    onSurface = w3w_theme_dark_onSurface,
    surfaceVariant = w3w_theme_dark_surfaceVariant,
    onSurfaceVariant = w3w_theme_dark_onSurfaceVariant,
    outline = w3w_theme_dark_outline,
    inverseOnSurface = w3w_theme_dark_inverseOnSurface,
    inverseSurface = w3w_theme_dark_inverseSurface,
    inversePrimary = w3w_theme_dark_inversePrimary,
    outlineVariant = w3w_theme_dark_outlineVariant,
    scrim = w3w_theme_dark_scrim,
    surfaceBright = w3w_theme_dark_surfaceBright,
    surfaceDim = w3w_theme_dark_surfaceDim,
    surfaceContainer = w3w_theme_dark_surfaceContainer,
    surfaceContainerHigh = w3w_theme_dark_surfaceContainerHigh,
    surfaceContainerLow = w3w_theme_dark_surfaceContainerLow,
    surfaceContainerHighest = w3w_theme_dark_surfaceContainerHighest,
    surfaceContainerLowest = w3w_theme_dark_surfaceContainerLowest
)

@Immutable
data class SuccessColors(
    val success: Color = Color.Unspecified,
    val onSuccess: Color = Color.Unspecified,
    val successContainer: Color = Color.Unspecified,
    val onSuccessContainer: Color = Color.Unspecified
)

val lightSuccessColors = SuccessColors(
    success = w3w_theme_light_success,
    onSuccess = w3w_theme_light_onSuccess,
    successContainer = w3w_theme_light_successContainer,
    onSuccessContainer = w3w_theme_light_onSuccessContainer
)

val darkSuccessColors = SuccessColors(
    success = w3w_theme_dark_success,
    onSuccess = w3w_theme_dark_onSuccess,
    successContainer = w3w_theme_dark_successContainer,
    onSuccessContainer = w3w_theme_dark_onSuccessContainer
)

val LocalDarkSuccessColors = staticCompositionLocalOf { darkSuccessColors }
val LocalLightSuccessColors = staticCompositionLocalOf { lightSuccessColors }

@Immutable
data class WarningColors(
    val warning: Color = Color.Unspecified,
    val onWarning: Color = Color.Unspecified,
    val warningContainer: Color = Color.Unspecified,
    val onWarningContainer: Color = Color.Unspecified
)

val lightWarningColors = WarningColors(
    warning = w3w_theme_light_warning,
    onWarning = w3w_theme_light_onWarning,
    warningContainer = w3w_theme_light_warningContainer,
    onWarningContainer = w3w_theme_light_onWarningContainer
)

val darkWarningColors = WarningColors(
    warning = w3w_theme_dark_warning,
    onWarning = w3w_theme_dark_onWarning,
    warningContainer = w3w_theme_dark_warningContainer,
    onWarningContainer = w3w_theme_dark_onWarningContainer
)

val LocalDarkWarningColors = staticCompositionLocalOf { darkWarningColors }
val LocalLightWarningColors = staticCompositionLocalOf { lightWarningColors }

@Immutable
data class W3wTypography(
    val titleMediumProminent: TextStyle,
    val labelLargeProminent: TextStyle,
    val labelMediumProminent: TextStyle
)

val LocalW3wTypography = staticCompositionLocalOf<W3wTypography?> { null }

val MaterialTheme.w3wTypography: W3wTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalW3wTypography.current ?: W3wTypography(
        titleMediumProminent = MaterialTheme.typography.titleMedium,
        labelLargeProminent = MaterialTheme.typography.labelLarge,
        labelMediumProminent = MaterialTheme.typography.labelMedium
    )

val MaterialTheme.warningColors: WarningColors
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme()) LocalDarkWarningColors.current else LocalLightWarningColors.current

val MaterialTheme.successColors: SuccessColors
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme()) LocalDarkSuccessColors.current else LocalLightSuccessColors.current