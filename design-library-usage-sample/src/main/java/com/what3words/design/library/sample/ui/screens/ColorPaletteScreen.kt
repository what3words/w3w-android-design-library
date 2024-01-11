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
import com.what3words.design.library.ui.theme.successColors
import com.what3words.design.library.ui.theme.warningColors

@Composable
fun ColorPaletteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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
                .background(MaterialTheme.warningColors.warning)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "warning / onWarning",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.warningColors.onWarning,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.warningColors.warningContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "warningContainer / onWarningContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.warningColors.onWarningContainer,
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(MaterialTheme.successColors.success)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "success / onSuccess",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.successColors.onSuccess,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.successColors.successContainer)
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "successContainer / onSuccessContainer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.successColors.onSuccessContainer,
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
    }
}