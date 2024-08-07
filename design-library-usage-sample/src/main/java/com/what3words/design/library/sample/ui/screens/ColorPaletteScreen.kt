package com.what3words.design.library.sample.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.w3wColorScheme

/**
 * A screen showcasing the color palette of the [MaterialTheme] and [W3WTheme].
 * This composable function displays various color combinations from the MaterialTheme color scheme,
 * including primary, secondary, error, warning, success, surface, and background colors.
 * Each color is demonstrated with its corresponding on-color (text color) for contrast.
 *
 * This screen serves as a visual guide to understanding the color scheme and how colors interact
 * with their respective on-colors, which is critical for maintaining accessibility and readability
 * in UI design.
 */
@Composable
fun ColorPaletteScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Colors",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "primary / onPrimary",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "primaryContainer / onPrimaryContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.inversePrimary)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "inversePrimary / onPrimaryContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "secondary / onSecondary",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "secondaryContainer / onSecondaryContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.w3wColorScheme.brand)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "brand / onBrand",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.w3wColorScheme.onBrand,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.w3wColorScheme.brandContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "brandContainer / onBrandContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.w3wColorScheme.onBrandContainer,
            )
        }

        Text(
            modifier = Modifier.padding(16.dp),
            text = "States",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.error)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "error / onError",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onError,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.errorContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "errorContainer / onErrorContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.w3wColorScheme.warning)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "warning / onWarning",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.w3wColorScheme.onWarning,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.w3wColorScheme.warningContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "warningContainer / onWarningContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.w3wColorScheme.onWarningContainer,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.w3wColorScheme.success)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "success / onSuccess",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.w3wColorScheme.onSuccess,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.w3wColorScheme.successContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "successContainer / onSuccessContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.w3wColorScheme.onSuccessContainer,
            )
        }

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Surfaces",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surface / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceVariant / onSurfaceVariant",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceDim)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceDim / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceBright)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceBright / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceContainerLowest / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerLow)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceContainerLow / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceContainer / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceContainerHigh / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "surfaceContainerHighest / onSurface",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Backgrounds",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "background / onBackground",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Outlines",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.outline)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "outline",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.outlineVariant)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "outlineVariant",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}