package com.what3words.design.library.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

/**
 * Represents a custom typography set for the What3words UI components. It extends the existing
 * MaterialTheme typography with additional semantic styles specific to What3words requirements.
 *
 * This data class defines custom text styles that are used across the What3words UI components.
 * While it provides a more semantic approach to defining text styles for specific What3words use cases,
 * it defaults back to MaterialTheme typography when no custom styles are set.
 *
 * @property headlineLargeProminent A TextStyle for large-sized headline text, more prominent variant.
 * @property titleMediumProminent A TextStyle for medium-sized title text, more prominent variant.
 * @property labelLargeProminent A TextStyle for large-sized label text, more prominent variant.
 * @property labelMediumProminent A TextStyle for medium-sized label text, more prominent variant.
 */
@Immutable
data class W3wTypography(
    val headlineLargeProminent: TextStyle,
    val titleMediumProminent: TextStyle,
    val labelLargeProminent: TextStyle,
    val labelMediumProminent: TextStyle
)

/**
 * A composition local providing access to the current [W3wTypography] instance.
 * When not explicitly set in the composition, it will be `null`.
 */
val LocalW3wTypography = staticCompositionLocalOf<W3wTypography?> { null }

/**
 * Extension property on [MaterialTheme] to provide easy access to [W3wTypography].
 * It returns the current [W3wTypography] from the composition or defaults to a new instance
 * mapped from MaterialTheme's typography if not present in the composition.
 */
val MaterialTheme.w3wTypography: W3wTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalW3wTypography.current ?: W3wTypography(
        headlineLargeProminent = MaterialTheme.typography.headlineLarge,
        titleMediumProminent = MaterialTheme.typography.titleMedium,
        labelLargeProminent = MaterialTheme.typography.labelLarge,
        labelMediumProminent = MaterialTheme.typography.labelMedium
    )