package com.what3words.design.library.sample.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.sample.ui.NavScreen
import com.what3words.design.library.ui.components.VoiceRecognitionAnimation
import com.what3words.design.library.ui.components.VoiceRecognitionState
import com.what3words.design.library.ui.components.What3wordsSearchBar
import com.what3words.design.library.ui.components.What3wordsAddress
import com.what3words.design.library.ui.components.What3wordsAddressListItem
import com.what3words.design.library.ui.theme.w3wColorScheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.random.Random

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Localized description",
                )
            }
        )
        Text(
            text = "Voice Recognition Component >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate(NavScreen.VoiceRecognitionAnimationScreen.route)
                },
            style = MaterialTheme.typography.titleMedium
        )
        val context = LocalContext.current
        val state: MutableState<VoiceRecognitionState> =
            remember { mutableStateOf(VoiceRecognitionState.Idle) }

        LaunchedEffect(Unit) {
            while (this.isActive) {
                delay(200)
                state.value =
                    VoiceRecognitionState.Active(Random.nextFloat().coerceIn(0f, 1f))
            }
        }

        VoiceRecognitionAnimation(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally),
            state = state.value,
            activeOnClick = {
                Toast.makeText(context, "Active clicked", Toast.LENGTH_SHORT).show()
            },
            inactiveOnClick = {
                Toast.makeText(context, "Inactive clicked", Toast.LENGTH_SHORT).show()
            }
        )

        Text(
            text = "Search bar >",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate(NavScreen.What3WordsSearchBarScreen.route)
                },
            style = MaterialTheme.typography.titleMedium
        )

        What3wordsSearchBar(
            modifier = Modifier
                .padding(4.dp),
            trailingActions = {
                IconButton(
                    onClick = {
                        navController.navigate(NavScreen.What3WordsSearchBarScreen.route)
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            leadingActions = {
                IconButton(
                    onClick = {
                        navController.navigate(NavScreen.What3WordsSearchBarScreen.route)
                    }) {
                    Icon(
                        imageVector = Icons.Default.SettingsVoice,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                IconButton(
                    onClick = {
                        navController.navigate(NavScreen.What3WordsSearchBarScreen.route)
                    }) {
                    Icon(
                        imageVector = Icons.Default.DocumentScanner,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
            },
            content = {
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Search")
            },
            onContentClick = {
                navController.navigate(NavScreen.What3WordsSearchBarScreen.route)
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
}