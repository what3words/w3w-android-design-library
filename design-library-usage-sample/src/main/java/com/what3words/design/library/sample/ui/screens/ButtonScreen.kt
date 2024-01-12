package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme

/**
 * Screen showcasing various button styles provided by Material Design in Compose styled by both [MaterialTheme] and [W3WTheme].
 * This screen displays different types of buttons, including filled, tonal, outlined,
 * elevated, and text buttons. Each button is shown in both its enabled and disabled states
 * to provide a visual understanding of the different states.
 *
 * This screen is useful for designers and developers to understand the visual and functional
 * differences between various button styles and states.
 */
@Composable
fun ButtonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Filled buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { },
            ) {
                Text("Filled")
            }
            Button(
                onClick = { },
                enabled = false
            ) {
                Text("Filled disabled")
            }
        }
        Text(
            text = "Tonal buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilledTonalButton(
                onClick = { },
            ) {
                Text("Tonal")
            }
            FilledTonalButton(
                onClick = { },
                enabled = false
            ) {
                Text("Tonal disabled")
            }
        }
        Text(
            text = "Outline buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = { },
            ) {
                Text("Outlined")
            }
            OutlinedButton(
                onClick = { },
                enabled = false
            ) {
                Text("Outlined disabled")
            }
        }
        Text(
            text = "Elevated buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ElevatedButton(
                onClick = { },
            ) {
                Text("Elevated")
            }
            ElevatedButton(
                onClick = { },
                enabled = false
            ) {
                Text("Elevated disabled")
            }
        }
        Text(
            text = "Text buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextButton(
                onClick = { },
            ) {
                Text("Text")
            }
            TextButton(
                onClick = { },
                enabled = false
            ) {
                Text("Text disabled")
            }
        }
    }
}