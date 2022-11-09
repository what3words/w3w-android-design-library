package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.what3words.design.library.sample.extensions.ColorSystemItem
import com.what3words.design.library.sample.extensions.toHexCode
import com.what3words.design.library.ui.components.ActionListItemType
import com.what3words.design.library.ui.components.FormField
import com.what3words.design.library.ui.components.ListItemAction
import com.what3words.design.library.ui.components.ListItemNavigation
import com.what3words.design.library.ui.components.NavigationBar
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun HomeScreen(navController: NavController) {
    NavigationBar(
        title = "What3words Android Design Library"
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(W3WTheme.colors.background)
                .verticalScroll(rememberScrollState())
                .padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
        ) {
            Text(
                text = "Colours",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary
            )
            Row(
                Modifier
                    .padding(W3WTheme.dimensions.paddingMedium)
                    .horizontalScroll(rememberScrollState())
            ) {
                ColorSystemItem(
                    context, W3WTheme.colors.primary, "primary", W3WTheme.colors.primary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.background,
                    "background",
                    W3WTheme.colors.background.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundHighlighted,
                    "highlightedBackground",
                    W3WTheme.colors.backgroundHighlighted.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textPrimary,
                    "textPrimary",
                    W3WTheme.colors.textPrimary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textSecondary,
                    "textSecondary",
                    W3WTheme.colors.textSecondary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textAccent,
                    "textAccent",
                    W3WTheme.colors.textAccent.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textFootnote,
                    "textFootnote",
                    W3WTheme.colors.textFootnote.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundError,
                    "backgroundError",
                    W3WTheme.colors.backgroundError.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textError,
                    "textError",
                    W3WTheme.colors.textError.toHexCode()
                )
            }
            Divider(
                color = W3WTheme.colors.primary, modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "Typography",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: title",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.title,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: headline",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: body",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.body,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: caption1",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.caption1,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: caption2",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.caption2,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: footnote",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )

            Divider(
                color = W3WTheme.colors.primary, modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "SuggestionWhat3words >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("SuggestionWhat3wordsScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )
            SuggestionWhat3wordsExample(title = "",
                words = "index.home.raft",
                country = "GB",
                near = "Bayswater, London",
                distance = 30,
                onClick = { navController.navigate("SuggestionWhat3wordsScreen") })
            Divider(
                color = W3WTheme.colors.primary, modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "SuggestionGeolocation >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("SuggestionGeolocationScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )
            GeolocationItemExample(
                title = "",
                primaryAddress = "Alfred Road",
                secondaryAddress = "London",
                isGeolocationGroup = true
            ) {
                navController.navigate("SuggestionGeolocationScreen")
            }

            Divider(
                color = W3WTheme.colors.primary, modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "ListItemNavigation >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("ListItemNavigationScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )
            Divider(color = Grey40)
            ListItemNavigation(
                title = "Contacts",
                leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Phone)
            ) {
                navController.navigate("ListItemNavigationScreen")
            }
            Divider(color = Grey40)
            Divider(
                color = W3WTheme.colors.primary, modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "ListItemAction >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("ListItemActionScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )

            var isChecked by remember { mutableStateOf(value = true) }
            Divider(color = Grey40)
            ListItemAction(title = "Contacts",
                isSelected = isChecked,
                actionListItemType = ActionListItemType.Checkbox,
                onClick = { b ->
                    isChecked = b
                })
            Divider(color = Grey40)

            Text(
                text = "Form Fields >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("FormFieldsScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )

            var text by remember { mutableStateOf(value = "Text") }
            FormField(
                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
                label = "Label",
                value = text,
                onValueChange = { text = it }
            )
            Divider(color = Grey40)
        }
    }
}