package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme

/**
 * A screen showcasing various styles of icon buttons in Material Design styled by both [MaterialTheme] and [W3WTheme].
 * This screen displays different types of icon buttons including standard, filled,
 * tonal, and outlined. Each button is presented in both its enabled and disabled states
 * to demonstrate the visual changes in different states.
 *
 * This screen is useful for designers and developers to understand the styling options
 * and states of icon buttons in a Material Design-based UI.
 */
@Composable
fun IconButtonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Icon buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(
                onClick = { },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
            IconButton(
                onClick = { },
                enabled = false
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
        Text(
            text = "Filled Icon buttons",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilledIconButton(
                onClick = { },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
            FilledIconButton(
                onClick = { },
                enabled = false
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
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
            FilledTonalIconButton(
                onClick = { },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
            FilledTonalIconButton(
                onClick = { },
                enabled = false
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
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
            OutlinedIconButton(
                onClick = { },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
            OutlinedIconButton(
                onClick = { },
                enabled = false
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    }
}