package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme

/**
 * Screen showcasing various usages of the [ListItem] composable styled by both [MaterialTheme] and [W3WTheme].
 * This screen displays a list of items with different configurations to demonstrate
 * how `ListItem` can be adapted to various UI needs. It includes examples with only text,
 * with leading and/or trailing icons, and with text that truncates with an ellipsis.
 *
 * Additionally, it demonstrates a right-to-left layout configuration to showcase bidirectional
 * UI support. Each list item is clickable but does not perform any actions in this demonstration.
 */
@Composable
fun ListItemScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Examples of ListItems with various configurations
        ListItem(
            modifier = Modifier.clickable {},
            headlineContent = { Text("List Item") },
            supportingContent = { Text("Supporting line text lorem ipsum dolor sit amet, consectetur.") },
            trailingContent = {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Localized description",
                )
            }
        )

        ListItem(
            modifier = Modifier.clickable {},
            headlineContent = { Text("List Item") },
            supportingContent = {
                Text(
                    "Supporting line text lorem ipsum dolor sit amet, consectetur.",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            trailingContent = {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Localized description",
                )
            }
        )

        ListItem(
            modifier = Modifier.clickable {},
            headlineContent = { Text("List Item") },
            trailingContent = {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Localized description",
                )
            }
        )

        ListItem(
            modifier = Modifier.clickable {},
            leadingContent = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Localized description",
                )
            },
            headlineContent = { Text("List Item") },
            supportingContent = { Text("Supporting line text lorem ipsum dolor sit amet, consectetur.") },
            trailingContent = {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Localized description",
                    )
                }
            }
        )

        ListItem(
            modifier = Modifier.clickable {},
            leadingContent = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Localized description",
                )
            },
            headlineContent = { Text("List Item") },
            supportingContent = {
                Text(
                    "Supporting line text lorem ipsum dolor sit amet, consectetur.",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            trailingContent = {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Localized description",
                    )
                }
            }
        )

        ListItem(
            modifier = Modifier.clickable {},
            leadingContent = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Localized description",
                )
            },
            headlineContent = { Text("List Item") },
            trailingContent = {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Localized description",
                    )
                }
            }
        )

        // ListItem with Right-to-Left layout configuration
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            ListItem(
                modifier = Modifier.clickable {},
                leadingContent = {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = "Localized description",
                    )
                },
                headlineContent = { Text("List Item") },
                trailingContent = {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = "Localized description",
                        )
                    }
                }
            )
        }
    }
}