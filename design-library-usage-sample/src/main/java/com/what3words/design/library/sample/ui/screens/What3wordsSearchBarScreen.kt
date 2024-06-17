package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.What3wordsAddress
import com.what3words.design.library.ui.components.What3wordsSearchBar

/**
 * Screen showcasing various usages of the [What3wordsSearchBar] composable styled by both [MaterialTheme] and [W3WTheme].
 * This screen displays a search bar with different configurations to demonstrate
 * how `What3wordsSearchBar` can be adapted to various UI needs. It includes examples with leading and/or trailing actions.
 *
 * Additionally, it demonstrates a right-to-left layout configuration to showcase bidirectional
 * UI support. Each search bar is clickable but does not perform any actions in this demonstration.
 */
@Composable
fun What3wordsSearchBarScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Full search bar",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        What3wordsSearchBar(
            modifier = Modifier
                .padding(4.dp),
            trailingActions = {
                IconButton(
                    onClick = {
                        // Handle action
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
                        // Handle action
                    }) {
                    Icon(
                        imageVector = Icons.Default.SettingsVoice,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                IconButton(
                    onClick = {
                        // Handle action
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
                // Handle action
            }
        )
        Text(
            text = "Search bar no leading actions",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        What3wordsSearchBar(
            modifier = Modifier
                .padding(4.dp),
            trailingActions = {
                IconButton(
                    onClick = {
                        // Handle action
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
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
                // Handle action
            }
        )
        Text(
            text = "Search bar no trailing actions",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        What3wordsSearchBar(
            modifier = Modifier
                .padding(4.dp),
            leadingActions = {
                IconButton(
                    onClick = {
                        // Handle action
                    }) {
                    Icon(
                        imageVector = Icons.Default.SettingsVoice,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                IconButton(
                    onClick = {
                        // Handle action
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
                // Handle action
            }
        )
        Text(
            text = "Search bar no actions",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        What3wordsSearchBar(
            modifier = Modifier
                .padding(4.dp),
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
                // Handle action
            }
        )
        Text(
            text = "Search bar full RTL",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                trailingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
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
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Default.SettingsVoice,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                    IconButton(
                        onClick = {
                            // Handle action
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
                    Text(text = "يبحث")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}