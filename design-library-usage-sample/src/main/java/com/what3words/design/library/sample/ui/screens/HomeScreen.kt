package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.What3wordsAddress
import com.what3words.design.library.ui.components.What3wordsAddressListItem

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                vertical = 16.dp
            )
    ) {
        ColorPalette(navController)
        Text(
            text = "What3words Address >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("What3wordsAddressScreen")
                },
            style = MaterialTheme.typography.titleMedium
        )

        What3wordsAddress(
            modifier = Modifier.padding(start = 16.dp),
            words = "filled.count.soap"
        )

        Text(
            text = "What3words Address List Item >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("What3wordsAddressListItemScreen")
                },
            style = MaterialTheme.typography.titleMedium
        )
        What3wordsAddressListItem(
            words = "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 0,
            isLand = false,
            label = "Label name",
            onClick = { navController.navigate("What3wordsAddressListItemScreen") }
        )

        Text(
            text = "Buttons >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("ButtonScreen")
                },
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { navController.navigate("ButtonScreen") },
            ) {
                Text("Filled")
            }
            Button(
                onClick = { navController.navigate("ButtonScreen") },
                enabled = false
            ) {
                Text("Filled disabled")
            }
        }

        Text(
            text = "Icon buttons >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("IconButtonScreen")
                },
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilledIconButton(
                onClick = { navController.navigate("IconButtonScreen") },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
            FilledIconButton(
                onClick = { navController.navigate("IconButtonScreen") },
                enabled = false
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }

        Text(
            text = "List Items >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("ListItemScreen")
                },
            style = MaterialTheme.typography.titleMedium
        )
        ListItem(
            modifier = Modifier.clickable {
                navController.navigate("ListItemScreen")
            },
            headlineContent = { Text("List Item") },
            leadingContent = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Localized description",
                )
            }
        )
    }
}

@Composable
fun ColorPalette(navController: NavController) {
    Text(
        text = "Color Palettes >",
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate("ColorPaletteScreen")
            },
        style = MaterialTheme.typography.titleMedium
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
}