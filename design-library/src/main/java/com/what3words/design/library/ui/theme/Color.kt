package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Defines the custom color palette for What3words, extending the MaterialTheme color scheme.
 * This includes both light and dark theme colors and additional semantic colors for specific UI components.
 * These colors can be overridden in specific parts of the app using local composition.
 */

// colors / primary
val w3w_theme_light_primary = Color(0xFF187DB9)
val w3w_theme_light_onPrimary = Color(0xFFFFFFFF)
val w3w_theme_light_primaryContainer = Color(0xFFDBEFFA)
val w3w_theme_light_onPrimaryContainer = Color(0xFF001D31)
val w3w_theme_light_inversePrimary = Color(0xFFC2E1EB)

val w3w_theme_dark_primary = Color(0xFF60B2F2)
val w3w_theme_dark_onPrimary = Color(0xFF0A3049)
val w3w_theme_dark_primaryContainer = Color(0xFF005379)
val w3w_theme_dark_onPrimaryContainer = Color(0xFFDBEFFA)
val w3w_theme_dark_inversePrimary = Color(0xFF006397)

// colors / secondary
val w3w_theme_light_secondary = Color(0xFF006397)
val w3w_theme_light_onSecondary = Color(0xFFFFFFFF)
val w3w_theme_light_secondaryContainer = Color(0xFFC2E1EB)
val w3w_theme_light_onSecondaryContainer = Color(0xFF001D31)

val w3w_theme_dark_secondary = Color(0xFFC2E1EB)
val w3w_theme_dark_onSecondary = Color(0xFF0A3049)
val w3w_theme_dark_secondaryContainer = Color(0xFF005379)
val w3w_theme_dark_onSecondaryContainer = Color(0xFFFCFCFF)

// colors / brand
val w3w_theme_light_brand = Color(0xFFE11F26)
val w3w_theme_light_onBrand = Color(0xFFFFFFFF)
val w3w_theme_light_brandContainer = Color(0xFFFFEDEA)
val w3w_theme_light_onBrandContainer = Color(0xFF930002)

val w3w_theme_dark_brand = Color(0xFFE11F26)
val w3w_theme_dark_onBrand = Color(0xFF410000)
val w3w_theme_dark_brandContainer = Color(0xFF930002)
val w3w_theme_dark_onBrandContainer = Color(0xFFFFCAC2)

// states / error
val w3w_theme_light_error = Color(0xFFF26C50)
val w3w_theme_light_onError = Color(0xFFFFFFFF)
val w3w_theme_light_errorContainer = Color(0xFFFFEDE9)
val w3w_theme_light_onErrorContainer = Color(0xFF3E0500)

val w3w_theme_dark_error = Color(0xFFFFB4A4)
val w3w_theme_dark_onError = Color(0xFF3E0500)
val w3w_theme_dark_errorContainer = Color(0xFFF26C50)
val w3w_theme_dark_onErrorContainer = Color(0xFF640D00)

// states / warning
val w3w_theme_light_warning = Color(0xFFC7AA00)
val w3w_theme_light_onWarning = Color(0xFFFFFFFF)
val w3w_theme_light_warningContainer = Color(0xFFFFFBFF)
val w3w_theme_light_onWarningContainer = Color(0xFF6F5D00)

val w3w_theme_dark_warning = Color(0xFFFFEC8A)
val w3w_theme_dark_onWarning = Color(0xFF6F5D00)
val w3w_theme_dark_warningContainer = Color(0xFFC7AA00)
val w3w_theme_dark_onWarningContainer = Color(0xFFFFF4B2)

// states / success.
val w3w_theme_light_success = Color(0xFF53C18A)
val w3w_theme_light_onSuccess = Color(0xFFFFFFFF)
val w3w_theme_light_successContainer = Color(0xFFF5FFF5)
val w3w_theme_light_onSuccessContainer = Color(0xFF003822)

val w3w_theme_dark_success = Color(0xFF6ECB9C)
val w3w_theme_dark_onSuccess = Color(0xFF003822)
val w3w_theme_dark_successContainer = Color(0xFF006C45)
val w3w_theme_dark_onSuccessContainer = Color(0xFF8BF8BD)

// surfaces
val w3w_theme_light_surfaceDim = Color(0xFFD9DADD)
val w3w_theme_light_surface = Color(0xFFF9F9FC)
val w3w_theme_light_surfaceBright = Color(0xFFFCFCFF)
val w3w_theme_light_surfaceVariant = Color(0xFFDFE3E8)
val w3w_theme_light_surfaceContainerLowest = Color(0xFFFFFFFF)
val w3w_theme_light_surfaceContainerLow = Color(0xFFF3F3F6)
val w3w_theme_light_surfaceContainer = Color(0xFFEDEEF0)
val w3w_theme_light_surfaceContainerHigh = Color(0xFFE7E8EB)
val w3w_theme_light_surfaceContainerHighest = Color(0xFFE2E2E5)
val w3w_theme_light_onSurface = Color(0xFF1A1C1E)
val w3w_theme_light_onSurfaceVariant = Color(0xFF43474B)
val w3w_theme_light_inverseSurface = Color(0xFF2E3133)
val w3w_theme_light_inverseOnSurface = Color(0xFFF0F0F3)

val w3w_theme_dark_surfaceDim = Color(0xFF111416)
val w3w_theme_dark_surface = Color(0xFF111416)
val w3w_theme_dark_surfaceBright = Color(0xFF37393C)
val w3w_theme_dark_surfaceVariant = Color(0xFF43474B)
val w3w_theme_dark_surfaceContainerLowest = Color(0xFF0C0E11)
val w3w_theme_dark_surfaceContainerLow = Color(0xFF1A1C1E)
val w3w_theme_dark_surfaceContainer = Color(0xFF1E2022)
val w3w_theme_dark_surfaceContainerHigh = Color(0xFF282A2D)
val w3w_theme_dark_surfaceContainerHighest = Color(0xFF333537)
val w3w_theme_dark_onSurface = Color(0xFFE2E2E5)
val w3w_theme_dark_onSurfaceVariant = Color(0xFFC3C7CC)
val w3w_theme_dark_inverseSurface = Color(0xFFE2E2E5)
val w3w_theme_dark_inverseOnSurface = Color(0xFF2E3133)

// outline
val w3w_theme_light_outline = Color(0xFF73777C)
val w3w_theme_light_outlineVariant = Color(0xFFC3C7CC)

val w3w_theme_dark_outline = Color(0xFF8D9196)
val w3w_theme_dark_outlineVariant = Color(0xFF43474B)

// backgrounds
val w3w_theme_light_background = Color(0xFFFFFBFF)
val w3w_theme_light_onBackground = Color(0xFF1A1C1E)

val w3w_theme_dark_background = Color(0xFF1A1C1E)
val w3w_theme_dark_onBackground = Color(0xFFE2E2E5)

//scrim
val w3w_theme_light_scrim = Color(0xFF000000)

val w3w_theme_dark_scrim = Color(0xFF000000)

/**
 * Defines a custom color scheme for What3words using the defined colors for light themes.
 */
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
    scrim = w3w_theme_light_scrim
)

/**
 * Defines a custom color scheme for What3words using the defined colors for dark themes.
 */
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
    scrim = w3w_theme_dark_scrim
)

/**
 * Data class representing custom surface variation colors, allowing for additional color customization. (to be deleted when updating material3 to 1.2.0)
 */
@Immutable
data class SurfaceVariationsColors(
    val surfaceBright: Color = Color.Unspecified,
    val surfaceDim: Color = Color.Unspecified,
    val surfaceContainer: Color = Color.Unspecified,
    val surfaceContainerHigh: Color = Color.Unspecified,
    val surfaceContainerLow: Color = Color.Unspecified,
    val surfaceContainerHighest: Color = Color.Unspecified,
    val surfaceContainerLowest: Color = Color.Unspecified,
)

// Success color assignments for light and dark themes.
val lightSurfaceVariationsColors = SurfaceVariationsColors(
    surfaceBright = w3w_theme_light_surfaceBright,
    surfaceDim = w3w_theme_light_surfaceDim,
    surfaceContainer = w3w_theme_light_surfaceContainer,
    surfaceContainerHigh = w3w_theme_light_surfaceContainerHigh,
    surfaceContainerLow = w3w_theme_light_surfaceContainerLow,
    surfaceContainerHighest = w3w_theme_light_surfaceContainerHighest,
    surfaceContainerLowest = w3w_theme_light_surfaceContainerLowest
)

val darkSurfaceVariationsColors = SurfaceVariationsColors(
    surfaceBright = w3w_theme_dark_surfaceBright,
    surfaceDim = w3w_theme_dark_surfaceDim,
    surfaceContainer = w3w_theme_dark_surfaceContainer,
    surfaceContainerHigh = w3w_theme_dark_surfaceContainerHigh,
    surfaceContainerLow = w3w_theme_dark_surfaceContainerLow,
    surfaceContainerHighest = w3w_theme_dark_surfaceContainerHighest,
    surfaceContainerLowest = w3w_theme_dark_surfaceContainerLowest
)

/**
 * Data class representing custom w3w colors, allowing for additional color customization.
 */
@Immutable
data class W3WColorScheme(
    val warning: Color = Color.Unspecified,
    val onWarning: Color = Color.Unspecified,
    val warningContainer: Color = Color.Unspecified,
    val onWarningContainer: Color = Color.Unspecified,
    val success: Color = Color.Unspecified,
    val onSuccess: Color = Color.Unspecified,
    val successContainer: Color = Color.Unspecified,
    val onSuccessContainer: Color = Color.Unspecified,
    val brand: Color = Color.Unspecified,
    val onBrand: Color = Color.Unspecified,
    val brandContainer: Color = Color.Unspecified,
    val onBrandContainer: Color = Color.Unspecified
)

// W3W proprietary color assignments for light and dark themes.
val lightW3WColors = W3WColorScheme(
    warning = w3w_theme_light_warning,
    onWarning = w3w_theme_light_onWarning,
    warningContainer = w3w_theme_light_warningContainer,
    onWarningContainer = w3w_theme_light_onWarningContainer,
    success = w3w_theme_light_success,
    onSuccess = w3w_theme_light_onSuccess,
    successContainer = w3w_theme_light_successContainer,
    onSuccessContainer = w3w_theme_light_onSuccessContainer,
    brand = w3w_theme_light_brand,
    onBrand = w3w_theme_light_onBrand,
    brandContainer = w3w_theme_light_brandContainer,
    onBrandContainer = w3w_theme_light_onBrandContainer
)

val darkW3WColors = W3WColorScheme(
    warning = w3w_theme_dark_warning,
    onWarning = w3w_theme_dark_onWarning,
    warningContainer = w3w_theme_dark_warningContainer,
    onWarningContainer = w3w_theme_dark_onWarningContainer,
    success = w3w_theme_dark_success,
    onSuccess = w3w_theme_dark_onSuccess,
    successContainer = w3w_theme_dark_successContainer,
    onSuccessContainer = w3w_theme_dark_onSuccessContainer,
    brand = w3w_theme_dark_brand,
    onBrand = w3w_theme_dark_onBrand,
    brandContainer = w3w_theme_dark_brandContainer,
    onBrandContainer = w3w_theme_dark_onBrandContainer
)

/**
 * Composition locals for custom success and warning colors.
 */
val LocalW3WColorScheme = staticCompositionLocalOf<W3WColorScheme?> { null }
val LocalSurfaceVariationsColors = staticCompositionLocalOf<SurfaceVariationsColors?> { null }

/**
 * Extension properties on [MaterialTheme] to provide easy access to custom warning and success colors.
 * The theme automatically switches between light and dark color sets based on the system theme.
 */
val MaterialTheme.w3wColorScheme: W3WColorScheme
    @Composable
    @ReadOnlyComposable
    get() = LocalW3WColorScheme.current
        ?: (if (isSystemInDarkTheme()) darkW3WColors else lightW3WColors)

//to be removed when updating material3 library
val MaterialTheme.surfaceVariationsColors: SurfaceVariationsColors
    @Composable
    @ReadOnlyComposable
    get() = LocalSurfaceVariationsColors.current
        ?: (if (isSystemInDarkTheme()) darkSurfaceVariationsColors else lightSurfaceVariationsColors)