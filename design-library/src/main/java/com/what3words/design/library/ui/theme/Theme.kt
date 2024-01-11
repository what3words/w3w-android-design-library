package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
fun W3WTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme)
        w3wDarkColors
    else w3wLightColors

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

    CompositionLocalProvider(
        LocalW3wTypography provides w3wTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}