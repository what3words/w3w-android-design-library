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

val colors_primary_core_primary_light_m3 = Color(0xff6750a4)
val colors_primary_core_primary_dark_m3 = Color(0xffcfbcff)
val colors_primary_core_primary_light_w3w = Color(0xff187db9)
val colors_primary_core_primary_dark_w3w = Color(0xff8dd4eb)
val colors_primary_core_on_primary_light_m3 = Color(0xffffffff)
val colors_primary_core_on_primary_dark_m3 = Color(0xff381e72)
val colors_primary_core_on_primary_light_w3w = Color(0xffffffff)
val colors_primary_core_on_primary_dark_w3w = Color(0xff0a3049)
val colors_primary_core_primary_container_light_m3 = Color(0xffe9ddff)
val colors_primary_core_primary_container_dark_m3 = Color(0xff4f378a)
val colors_primary_core_primary_container_light_w3w = Color(0xffdbeffa)
val colors_primary_core_primary_container_dark_w3w = Color(0xff005379)
val colors_primary_core_on_primary_container_light_m3 = Color(0xff22005d)
val colors_primary_core_on_primary_container_dark_m3 = Color(0xffe9ddff)
val colors_primary_core_on_primary_container_light_w3w = Color(0xff0a3049)
val colors_primary_core_on_primary_container_dark_w3w = Color(0xffdbeffa)
val colors_primary_core_inverse_primary_light_m3 = Color(0xffcfbcff)
val colors_primary_core_inverse_primary_dark_m3 = Color(0xff6750a4)
val colors_primary_core_inverse_primary_light_w3w = Color(0xffc2e1eb)
val colors_primary_core_inverse_primary_dark_w3w = Color(0xff006397)
val colors_secondary_core_secondary_light_m3 = Color(0xff625b71)
val colors_secondary_core_secondary_dark_m3 = Color(0xffcbc2db)
val colors_secondary_core_secondary_light_w3w = Color(0xff006397)
val colors_secondary_core_secondary_dark_w3w = Color(0xff187db9)
val colors_brand_brand_light_m3 = Color(0xff53c18a)
val colors_brand_brand_dark_m3 = Color(0xff53c18a)
val colors_brand_brand_light_w3w = Color(0xffe11f26)
val colors_brand_brand_dark_w3w = Color(0xffe11f26)
val colors_brand_on_brand_light_m3 = Color(0xffffffff)
val colors_brand_on_brand_dark_m3 = Color(0xff003822)
val colors_brand_on_brand_light_w3w = Color(0xfffffbff)
val colors_brand_on_brand_dark_w3w = Color(0xfffffbff)
val colors_brand_brand_container_light_m3 = Color(0xff8bf8bd)
val colors_brand_brand_container_dark_m3 = Color(0xff006c45)
val colors_brand_brand_container_light_w3w = Color(0xffffedea)
val colors_brand_brand_container_dark_w3w = Color(0xff930002)
val colors_brand_on_brand_container_light_m3 = Color(0xff002112)
val colors_brand_on_brand_container_dark_m3 = Color(0xff8bf8bd)
val colors_brand_on_brand_container_light_w3w = Color(0xff930002)
val colors_brand_on_brand_container_dark_w3w = Color(0xffffcac2)
val colors_secondary_core_on_secondary_light_m3 = Color(0xffffffff)
val colors_secondary_core_on_secondary_dark_m3 = Color(0xff332d41)
val colors_secondary_core_on_secondary_light_w3w = Color(0xffffffff)
val colors_secondary_core_on_secondary_dark_w3w = Color(0xffdbeffa)
val colors_secondary_core_secondary_container_light_m3 = Color(0xffe8def8)
val colors_secondary_core_secondary_container_dark_m3 = Color(0xff4a4458)
val colors_secondary_core_secondary_container_light_w3w = Color(0xffc2e1eb)
val colors_secondary_core_secondary_container_dark_w3w = Color(0xff005379)
val colors_secondary_core_on_secondary_container_light_m3 = Color(0xff1e192b)
val colors_secondary_core_on_secondary_container_dark_m3 = Color(0xffe8def8)
val colors_secondary_core_on_secondary_container_light_w3w = Color(0xff0a3049)
val colors_secondary_core_on_secondary_container_dark_w3w = Color(0xfffcfcff)
val states_error_error_light_m3 = Color(0xff93000a)
val states_error_error_dark_m3 = Color(0xffffdad6)
val states_error_error_light_w3w = Color(0xfff26c50)
val states_error_error_dark_w3w = Color(0xffffb4a4)
val states_warning_warning_light_m3 = Color(0xffc7aa00)
val states_warning_warning_dark_m3 = Color(0xffffec8a)
val states_warning_warning_light_w3w = Color(0xffc7aa00)
val states_warning_warning_dark_w3w = Color(0xffffec8a)
val states_success_success_light_m3 = Color(0xff53c18a)
val states_success_success_dark_m3 = Color(0xff6ecb9c)
val states_success_success_light_w3w = Color(0xff53c18a)
val states_success_success_dark_w3w = Color(0xff6ecb9c)
val states_success_on_success_light_m3 = Color(0xffffffff)
val states_success_on_success_dark_m3 = Color(0xff003822)
val states_success_on_success_light_w3w = Color(0xffffffff)
val states_success_on_success_dark_w3w = Color(0xff003822)
val states_success_success_container_light_m3 = Color(0xfff5fff5)
val states_success_success_container_dark_m3 = Color(0xff006c45)
val states_success_success_container_light_w3w = Color(0xfff5fff5)
val states_success_success_container_dark_w3w = Color(0xff006c45)
val states_success_on_success_container_light_m3 = Color(0xff003822)
val states_success_on_success_container_dark_m3 = Color(0xffa2dfbd)
val states_success_on_success_container_light_w3w = Color(0xff003822)
val states_success_on_success_container_dark_w3w = Color(0xffa2dfbd)
val states_warning_on_warning_light_m3 = Color(0xffffffff)
val states_warning_on_warning_dark_m3 = Color(0xff6f5d00)
val states_warning_on_warning_light_w3w = Color(0xffffffff)
val states_warning_on_warning_dark_w3w = Color(0xff2f2500)
val states_warning_warning_container_light_m3 = Color(0xfffffbff)
val states_warning_warning_container_dark_m3 = Color(0xffc7aa00)
val states_warning_warning_container_light_w3w = Color(0xfffffbff)
val states_warning_warning_container_dark_w3w = Color(0xffc7aa00)
val states_warning_on_warning_container_light_m3 = Color(0xff6f5d00)
val states_warning_on_warning_container_dark_m3 = Color(0xfffff4b2)
val states_warning_on_warning_container_light_w3w = Color(0xff2f2500)
val states_warning_on_warning_container_dark_w3w = Color(0xfffff4b2)
val states_error_on_error_light_m3 = Color(0xffffffff)
val states_error_on_error_dark_m3 = Color(0xff410002)
val states_error_on_error_light_w3w = Color(0xffffffff)
val states_error_on_error_dark_w3w = Color(0xff3e0500)
val states_error_error_container_light_m3 = Color(0xffffedea)
val states_error_error_container_dark_m3 = Color(0xff93000a)
val states_error_error_container_light_w3w = Color(0xffffede9)
val states_error_error_container_dark_w3w = Color(0xfff26c50)
val states_error_on_error_container_light_m3 = Color(0xff93000a)
val states_error_on_error_container_dark_m3 = Color(0xffffdad6)
val states_error_on_error_container_light_w3w = Color(0xff3e0500)
val states_error_on_error_container_dark_w3w = Color(0xff640d00)
val surfaces_surface_dim_light_m3 = Color(0xffded8e1)
val surfaces_surface_dim_dark_m3 = Color(0xff141218)
val surfaces_surface_dim_light_w3w = Color(0xffd9dadd)
val surfaces_surface_dim_dark_w3w = Color(0xff111416)
val surfaces_surface_light_m3 = Color(0xfffffbfe)
val surfaces_surface_dark_m3 = Color(0xff141218)
val surfaces_surface_light_w3w = Color(0xfff9f9fc)
val surfaces_surface_dark_w3w = Color(0xff111416)
val surfaces_surface_bright_light_m3 = Color(0xfffffbff)
val surfaces_surface_bright_dark_m3 = Color(0xff3b383e)
val surfaces_surface_bright_light_w3w = Color(0xfffcfcff)
val surfaces_surface_bright_dark_w3w = Color(0xff37393c)
val surfaces_surface_variant_light_m3 = Color(0xffe7e0ec)
val surfaces_surface_variant_dark_m3 = Color(0xff49454f)
val surfaces_surface_variant_light_w3w = Color(0xffdfe3e8)
val surfaces_surface_variant_dark_w3w = Color(0xff43474b)
val surfaces_surface_container_lowest_light_m3 = Color(0xffffffff)
val surfaces_surface_container_lowest_dark_m3 = Color(0xff0f0d13)
val surfaces_surface_container_lowest_light_w3w = Color(0xffffffff)
val surfaces_surface_container_lowest_dark_w3w = Color(0xff0c0e11)
val surfaces_surface_container_low_light_m3 = Color(0xfff7f2fa)
val surfaces_surface_container_low_dark_m3 = Color(0xff1d1b20)
val surfaces_surface_container_low_light_w3w = Color(0xfff3f3f6)
val surfaces_surface_container_low_dark_w3w = Color(0xff1a1c1e)
val surfaces_surface_container_light_m3 = Color(0xfff3edf7)
val surfaces_surface_container_dark_m3 = Color(0xff211f26)
val surfaces_surface_container_light_w3w = Color(0xffedeef0)
val surfaces_surface_container_dark_w3w = Color(0xff1e2022)
val surfaces_surface_container_high_light_m3 = Color(0xffece6f0)
val surfaces_surface_container_high_dark_m3 = Color(0xff2b2930)
val surfaces_surface_container_high_light_w3w = Color(0xffe7e8eb)
val surfaces_surface_container_high_dark_w3w = Color(0xff282a2d)
val surfaces_surface_container_highest_light_m3 = Color(0xffe6e0e9)
val surfaces_surface_container_highest_dark_m3 = Color(0xff36343b)
val surfaces_surface_container_highest_light_w3w = Color(0xffe2e2e5)
val surfaces_surface_container_highest_dark_w3w = Color(0xff333537)
val surfaces_on_surface_light_m3 = Color(0xff1d1b20)
val surfaces_on_surface_dark_m3 = Color(0xffe6e0e9)
val surfaces_on_surface_light_w3w = Color(0xff1a1c1e)
val surfaces_on_surface_dark_w3w = Color(0xffffffff)
val surfaces_on_surface_variant_light_m3 = Color(0xff49454f)
val surfaces_on_surface_variant_dark_m3 = Color(0xffcac4d0)
val surfaces_on_surface_variant_light_w3w = Color(0xff43474b)
val surfaces_on_surface_variant_dark_w3w = Color(0xffc3c7cc)
val surfaces_on_surface_white_light_m3 = Color(0xfffffbfe)
val surfaces_on_surface_white_dark_m3 = Color(0xfffffbfe)
val surfaces_on_surface_white_light_w3w = Color(0xfff9f9fc)
val surfaces_on_surface_white_dark_w3w = Color(0xfffffbfe)
val surfaces_on_surface_black_light_m3 = Color(0xff141218)
val surfaces_on_surface_black_dark_m3 = Color(0xff141218)
val surfaces_on_surface_black_light_w3w = Color(0xff111416)
val surfaces_on_surface_black_dark_w3w = Color(0xff111416)
val surfaces_inverse_surface_light_m3 = Color(0xff141218)
val surfaces_inverse_surface_dark_m3 = Color(0xfffffbfe)
val surfaces_inverse_surface_light_w3w = Color(0xff111416)
val surfaces_inverse_surface_dark_w3w = Color(0xfff9f9fc)
val surfaces_inverse_on_surface_light_m3 = Color(0xffe6e0e9)
val surfaces_inverse_on_surface_dark_m3 = Color(0xff1d1b20)
val surfaces_inverse_on_surface_light_w3w = Color(0xffffffff)
val surfaces_inverse_on_surface_dark_w3w = Color(0xff1a1c1e)
val outlines_outline_light_m3 = Color(0xff79747e)
val outlines_outline_dark_m3 = Color(0xff938f99)
val outlines_outline_light_w3w = Color(0xff73777c)
val outlines_outline_dark_w3w = Color(0xff8d9196)
val outlines_outline_variant_light_m3 = Color(0xffcac4d0)
val outlines_outline_variant_dark_m3 = Color(0xff49454f)
val outlines_outline_variant_light_w3w = Color(0xffc3c7cc)
val outlines_outline_variant_dark_w3w = Color(0xff43474b)
val backgrounds_background_light_m3 = Color(0xfffffbfe)
val backgrounds_background_dark_m3 = Color(0xff1d1b20)
val backgrounds_background_light_w3w = Color(0xfffffbff)
val backgrounds_background_dark_w3w = Color(0xff000000)
val backgrounds_on_background_light_m3 = Color(0xff1d1b20)
val backgrounds_on_background_dark_m3 = Color(0xffe6e0e9)
val backgrounds_on_background_light_w3w = Color(0xff1a1c1e)
val backgrounds_on_background_dark_w3w = Color(0xffe2e2e5)
val scrim_scrim_light_m3 = Color(0xff000000)
val scrim_scrim_dark_m3 = Color(0xff000000)
val scrim_scrim_light_w3w = Color(0xff000000)
val scrim_scrim_dark_w3w = Color(0xff000000)
val shadow_shadow_light_m3 = Color(0xff000000)
val shadow_shadow_dark_m3 = Color(0xff000000)
val shadow_shadow_light_w3w = Color(0xff000000)
val shadow_shadow_dark_w3w = Color(0xff000000)

/**
 * Defines a custom color scheme for What3words using the defined colors for light themes.
 */
internal val w3wLightColors = lightColorScheme(
    primary = colors_primary_core_primary_light_w3w,
    onPrimary = colors_primary_core_on_primary_light_w3w,
    primaryContainer = colors_primary_core_primary_container_light_w3w,
    onPrimaryContainer = colors_primary_core_on_primary_container_light_w3w,
    secondary = colors_secondary_core_secondary_light_w3w,
    onSecondary = colors_secondary_core_on_secondary_light_w3w,
    secondaryContainer = colors_secondary_core_secondary_container_light_w3w,
    onSecondaryContainer = colors_secondary_core_on_secondary_container_light_w3w,
    error = states_error_error_light_w3w,
    errorContainer = states_error_error_container_light_w3w,
    onError = states_error_on_error_light_w3w,
    onErrorContainer = states_error_on_error_container_light_w3w,
    background = backgrounds_background_light_w3w,
    onBackground = backgrounds_on_background_light_w3w,
    surface = surfaces_surface_light_w3w,
    onSurface = surfaces_on_surface_light_w3w,
    surfaceVariant = surfaces_surface_variant_light_w3w,
    onSurfaceVariant = surfaces_on_surface_variant_light_w3w,
    outline = outlines_outline_light_w3w,
    inverseOnSurface = surfaces_inverse_on_surface_light_w3w,
    inverseSurface = surfaces_inverse_surface_light_w3w,
    inversePrimary = colors_primary_core_inverse_primary_light_w3w,
    outlineVariant = outlines_outline_variant_light_w3w,
    scrim = scrim_scrim_light_w3w
)

/**
 * Defines a custom color scheme for What3words using the defined colors for dark themes.
 */
internal val w3wDarkColors = darkColorScheme(
    primary = colors_primary_core_primary_dark_w3w,
    onPrimary = colors_primary_core_on_primary_dark_w3w,
    primaryContainer = colors_primary_core_primary_container_dark_w3w,
    onPrimaryContainer = colors_primary_core_on_primary_container_dark_w3w,
    secondary = colors_secondary_core_secondary_dark_w3w,
    onSecondary = colors_secondary_core_on_secondary_dark_w3w,
    secondaryContainer = colors_secondary_core_secondary_container_dark_w3w,
    onSecondaryContainer = colors_secondary_core_on_secondary_container_dark_w3w,
    error = states_error_error_dark_w3w,
    errorContainer = states_error_error_container_dark_w3w,
    onError = states_error_on_error_dark_w3w,
    onErrorContainer = states_error_on_error_container_dark_w3w,
    background = backgrounds_background_dark_w3w,
    onBackground = backgrounds_on_background_dark_w3w,
    surface = surfaces_surface_dark_w3w,
    onSurface = surfaces_on_surface_dark_w3w,
    surfaceVariant = surfaces_surface_variant_dark_w3w,
    onSurfaceVariant = surfaces_on_surface_variant_dark_w3w,
    outline = outlines_outline_dark_w3w,
    inverseOnSurface = surfaces_inverse_on_surface_dark_w3w,
    inverseSurface = surfaces_inverse_surface_dark_w3w,
    inversePrimary = colors_primary_core_inverse_primary_dark_w3w,
    outlineVariant = outlines_outline_variant_dark_w3w,
    scrim = scrim_scrim_dark_w3w
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
val w3wLightSurfaceVariationsColors = SurfaceVariationsColors(
    surfaceBright = surfaces_surface_bright_light_w3w,
    surfaceDim = surfaces_surface_dim_light_w3w,
    surfaceContainer = surfaces_surface_container_light_w3w,
    surfaceContainerHigh = surfaces_surface_container_high_light_w3w,
    surfaceContainerLow = surfaces_surface_container_low_light_w3w,
    surfaceContainerHighest = surfaces_surface_container_highest_light_w3w,
    surfaceContainerLowest = surfaces_surface_container_lowest_light_w3w
)

val w3wDarkSurfaceVariationsColors = SurfaceVariationsColors(
    surfaceBright = surfaces_surface_bright_dark_w3w,
    surfaceDim = surfaces_surface_dim_dark_w3w,
    surfaceContainer = surfaces_surface_container_dark_w3w,
    surfaceContainerHigh = surfaces_surface_container_high_dark_w3w,
    surfaceContainerLow = surfaces_surface_container_low_dark_w3w,
    surfaceContainerHighest = surfaces_surface_container_highest_dark_w3w,
    surfaceContainerLowest = surfaces_surface_container_lowest_dark_w3w
)

// Success color assignments for light and dark themes.
val m3LightSurfaceVariationsColors = SurfaceVariationsColors(
    surfaceBright = surfaces_surface_bright_light_m3,
    surfaceDim = surfaces_surface_dim_light_m3,
    surfaceContainer = surfaces_surface_container_light_m3,
    surfaceContainerHigh = surfaces_surface_container_high_light_m3,
    surfaceContainerLow = surfaces_surface_container_low_light_m3,
    surfaceContainerHighest = surfaces_surface_container_highest_light_m3,
    surfaceContainerLowest = surfaces_surface_container_lowest_light_m3
)

val m3DarkSurfaceVariationsColors = SurfaceVariationsColors(
    surfaceBright = surfaces_surface_bright_dark_m3,
    surfaceDim = surfaces_surface_dim_dark_m3,
    surfaceContainer = surfaces_surface_container_dark_m3,
    surfaceContainerHigh = surfaces_surface_container_high_dark_m3,
    surfaceContainerLow = surfaces_surface_container_low_dark_m3,
    surfaceContainerHighest = surfaces_surface_container_highest_dark_m3,
    surfaceContainerLowest = surfaces_surface_container_lowest_dark_m3
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
val w3wLightW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_light_w3w,
    onWarning = states_warning_on_warning_light_w3w,
    warningContainer = states_warning_warning_container_light_w3w,
    onWarningContainer = states_warning_on_warning_container_light_w3w,
    success = states_success_success_light_w3w,
    onSuccess = states_success_on_success_light_w3w,
    successContainer = states_success_success_container_light_w3w,
    onSuccessContainer = states_success_on_success_container_light_w3w,
    brand = colors_brand_brand_light_w3w,
    onBrand = colors_brand_on_brand_light_w3w,
    brandContainer = colors_brand_brand_container_light_w3w,
    onBrandContainer = colors_brand_on_brand_container_light_w3w
)

val w3wDarkW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_dark_w3w,
    onWarning = states_warning_on_warning_dark_w3w,
    warningContainer = states_warning_warning_container_dark_w3w,
    onWarningContainer = states_warning_on_warning_container_dark_w3w,
    success = states_success_success_dark_w3w,
    onSuccess = states_success_on_success_dark_w3w,
    successContainer = states_success_success_container_dark_w3w,
    onSuccessContainer = states_success_on_success_container_dark_w3w,
    brand = colors_brand_brand_dark_w3w,
    onBrand = colors_brand_on_brand_dark_w3w,
    brandContainer = colors_brand_brand_container_dark_w3w,
    onBrandContainer = colors_brand_on_brand_container_dark_w3w
)

val m3LightW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_light_m3,
    onWarning = states_warning_on_warning_light_m3,
    warningContainer = states_warning_warning_container_light_m3,
    onWarningContainer = states_warning_on_warning_container_light_m3,
    success = states_success_success_light_m3,
    onSuccess = states_success_on_success_light_m3,
    successContainer = states_success_success_container_light_m3,
    onSuccessContainer = states_success_on_success_container_light_m3,
    brand = colors_brand_brand_light_m3,
    onBrand = colors_brand_on_brand_light_m3,
    brandContainer = colors_brand_brand_container_light_m3,
    onBrandContainer = colors_brand_on_brand_container_light_m3
)

val m3DarkW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_dark_m3,
    onWarning = states_warning_on_warning_dark_m3,
    warningContainer = states_warning_warning_container_dark_m3,
    onWarningContainer = states_warning_on_warning_container_dark_m3,
    success = states_success_success_dark_m3,
    onSuccess = states_success_on_success_dark_m3,
    successContainer = states_success_success_container_dark_m3,
    onSuccessContainer = states_success_on_success_container_dark_m3,
    brand = colors_brand_brand_dark_m3,
    onBrand = colors_brand_on_brand_dark_m3,
    brandContainer = colors_brand_brand_container_dark_m3,
    onBrandContainer = colors_brand_on_brand_container_dark_m3
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
        ?: (if (isSystemInDarkTheme()) m3DarkW3WSchemeColors else m3LightW3WSchemeColors)

//to be removed when updating material3 library
val MaterialTheme.surfaceVariationsColors: SurfaceVariationsColors
    @Composable
    @ReadOnlyComposable
    get() = LocalSurfaceVariationsColors.current
        ?: (if (isSystemInDarkTheme()) m3DarkSurfaceVariationsColors else m3LightSurfaceVariationsColors)