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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
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
        What3wordsAddressExample(title = "",
            words = "index.home.raft",
            country = "GB",
            near = "Bayswater, London",
            distance = 30,
            onClick = { navController.navigate("What3wordsAddressScreen") }
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
                    navController.navigate("IconButtonScreen")
                },
            style = MaterialTheme.typography.titleMedium
        )
        ListItem(
            modifier = Modifier.clickable {
                navController.navigate("IconButtonScreen")
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
//            Text(
//                text = "SuggestionGeolocation >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall,
//                        bottom = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("SuggestionGeolocationScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//            GeolocationItemExample(
//                title = "",
//                primaryAddress = "Alfred Road",
//                secondaryAddress = "London",
//                isGeolocationGroup = true
//            ) {
//                navController.navigate("SuggestionGeolocationScreen")
//            }
//            Text(
//                text = "ListItemNavigation >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall,
//                        bottom = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("ListItemNavigationScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//            Divider(color = W3WTheme.colors.divider)
//            ListItemNavigation(
//                title = "Contacts",
//                startIconPainter = rememberVectorPainter(image = Icons.Outlined.Phone)
//            ) {
//                navController.navigate("ListItemNavigationScreen")
//            }
//            Text(
//                text = "ListItemAction >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall,
//                        bottom = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("ListItemActionScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//
//            var isChecked by remember { mutableStateOf(value = true) }
//            Divider(color = W3WTheme.colors.divider)
//            ListItemAction(title = "Contacts",
//                isChecked = isChecked,
//                listItemActionType = ListItemActionType.Checkbox,
//                onCheckedChange = { b ->
//                    isChecked = b
//                })
//
//            Text(
//                text = "Form Fields >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall,
//                        bottom = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("FormFieldsScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//
//            var text by remember { mutableStateOf(value = "Text") }
//            FormField(
//                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
//                label = "Label",
//                value = text,
//                onValueChange = { text = it }
//            )
//            Divider(color = W3WTheme.colors.divider)
//
//            Text(
//                text = "Notifications >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("NotificationScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//
//            Notification(
//                text = "Notification sample text",
//                type = NotificationType.Error,
//                modifier = Modifier.padding(vertical = W3WTheme.dimensions.paddingSmall)
//            )
//
//            Divider(color = W3WTheme.colors.divider)
//
//            Text(
//                text = "Buttons >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall,
//                        bottom = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("ButtonScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//
//            PrimaryButton(
//                text = "click here to see all button types and sizes",
//                buttonSize = ButtonSize.Medium,
//                onClick = { navController.navigate("ButtonScreen") },
//                modifier = Modifier.padding(start = W3WTheme.dimensions.paddingMedium, bottom = W3WTheme.dimensions.paddingMedium)
//            )
//
//            Divider(color = W3WTheme.colors.divider)
//
//            Text(
//                text = "IconButtons >",
//                modifier = Modifier
//                    .padding(
//                        top = W3WTheme.dimensions.paddingMedium,
//                        start = W3WTheme.dimensions.paddingSmall,
//                        end = W3WTheme.dimensions.paddingSmall,
//                        bottom = W3WTheme.dimensions.paddingSmall
//                    )
//                    .clickable {
//                        navController.navigate("IconButtonScreen")
//                    },
//                style = W3WTheme.typography.headline,
//                color = W3WTheme.colors.primary,
//            )
//
//            Row {
//                FilledIconButton(
//                    icon = painterResource(id = R.drawable.ic_add),
//                    buttonSize = IconButtonSize.Medium,
//                    onClick = { navController.navigate("IconButtonScreen") },
//                    modifier = Modifier.padding(
//                        horizontal = W3WTheme.dimensions.paddingMedium,
//                        vertical = W3WTheme.dimensions.paddingMedium
//                    )
//                )
//                GhostFilledIconButton(
//                    icon = painterResource(id = R.drawable.ic_add),
//                    buttonSize = IconButtonSize.Medium,
//                    onClick = { navController.navigate("IconButtonScreen") },
//                    modifier = Modifier.padding(
//                        horizontal = W3WTheme.dimensions.paddingMedium,
//                        vertical = W3WTheme.dimensions.paddingMedium
//                    )
//                )
//                OutlinedIconButton(
//                    icon = painterResource(id = R.drawable.ic_add),
//                    buttonSize = IconButtonSize.Medium,
//                    onClick = { navController.navigate("IconButtonScreen") },
//                    modifier = Modifier.padding(
//                        horizontal = W3WTheme.dimensions.paddingMedium,
//                        vertical = W3WTheme.dimensions.paddingMedium
//                    )
//                )
//            }
//        }
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