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
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.what3words.design.library.sample.components.ColorSystemItem
import com.what3words.design.library.sample.extensions.toHexCode
import com.what3words.design.library.ui.components.ListItemActionType
import com.what3words.design.library.ui.components.ButtonSize
import com.what3words.design.library.ui.components.FilledIconButton
import com.what3words.design.library.ui.components.FormField
import com.what3words.design.library.ui.components.GhostFilledIconButton
import com.what3words.design.library.ui.components.IconButtonSize
import com.what3words.design.library.ui.components.ListItemAction
import com.what3words.design.library.ui.components.ListItemNavigation
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.components.Notification
import com.what3words.design.library.ui.components.NotificationType
import com.what3words.design.library.ui.components.OutlinedIconButton
import com.what3words.design.library.ui.components.PrimaryButton
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun HomeScreen(navController: NavController) {
    NavigationBarScaffold(
        title = "What3words Android Design Library"
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(W3WTheme.colors.background)
                .verticalScroll(rememberScrollState())
                .padding(
                    vertical = W3WTheme.dimensions.paddingMedium
                )
        ) {
            Text(
                text = "Colours",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary
            )
            Row(
                Modifier
                    .padding(
                        vertical = W3WTheme.dimensions.paddingMedium
                    )
                    .horizontalScroll(rememberScrollState())
            ) {
                ColorSystemItem(
                    context, W3WTheme.colors.primary, "primary", W3WTheme.colors.primary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.accent,
                    "accent",
                    W3WTheme.colors.accent.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.background,
                    "background",
                    W3WTheme.colors.background.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundSecondary,
                    "backgroundSecondary",
                    W3WTheme.colors.backgroundSecondary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundHighlighted,
                    "highlightedBackground",
                    W3WTheme.colors.backgroundHighlighted.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundDisabled,
                    "backgroundDisabled",
                    W3WTheme.colors.backgroundDisabled.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundError,
                    "backgroundError",
                    W3WTheme.colors.backgroundError.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundWarning,
                    "backgroundWarning",
                    W3WTheme.colors.backgroundWarning.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundConfirmation,
                    "backgroundConfirmation",
                    W3WTheme.colors.backgroundConfirmation.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundInformation,
                    "backgroundInformation",
                    W3WTheme.colors.backgroundInformation.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textPrimary,
                    "textPrimary",
                    W3WTheme.colors.textPrimary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textPlaceholder,
                    "textPlaceholder",
                    W3WTheme.colors.textPlaceholder.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textNotification,
                    "textNotification",
                    W3WTheme.colors.textNotification.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.divider,
                    "divider",
                    W3WTheme.colors.divider.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.border,
                    "border",
                    W3WTheme.colors.border.toHexCode()
                )
            }
            Divider(
                color = W3WTheme.colors.divider, modifier = Modifier.padding(
                    vertical = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "Typography",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary
            )
            Text(
                text = "- This text is using typography: title",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.title,
                color = W3WTheme.colors.primary
            )
            Text(
                text = "- This text is using typography: headline",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary
            )
            Text(
                text = "- This text is using typography: body",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.body,
                color = W3WTheme.colors.primary
            )
            Text(
                text = "- This text is using typography: caption1",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.caption1,
                color = W3WTheme.colors.primary
            )
            Text(
                text = "- This text is using typography: caption2",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.caption2,
                color = W3WTheme.colors.primary
            )
            Text(
                text = "- This text is using typography: footnote",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.primary
            )

            Divider(
                color = W3WTheme.colors.divider, modifier = Modifier.padding(
                    vertical = W3WTheme.dimensions.paddingMedium
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
                color = W3WTheme.colors.primary,
            )
            SuggestionWhat3wordsExample(title = "",
                words = "index.home.raft",
                country = "GB",
                near = "Bayswater, London",
                distance = 30,
                onClick = { navController.navigate("SuggestionWhat3wordsScreen") })
            Text(
                text = "SuggestionGeolocation >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("SuggestionGeolocationScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )
            GeolocationItemExample(
                title = "",
                primaryAddress = "Alfred Road",
                secondaryAddress = "London",
                isGeolocationGroup = true
            ) {
                navController.navigate("SuggestionGeolocationScreen")
            }
            Text(
                text = "ListItemNavigation >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("ListItemNavigationScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemNavigation(
                title = "Contacts",
                startIconPainter = rememberVectorPainter(image = Icons.Outlined.Phone)
            ) {
                navController.navigate("ListItemNavigationScreen")
            }
            Text(
                text = "ListItemAction >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("ListItemActionScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )

            var isChecked by remember { mutableStateOf(value = true) }
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(title = "Contacts",
                isChecked = isChecked,
                listItemActionType = ListItemActionType.Checkbox,
                onCheckedChange = { b ->
                    isChecked = b
                })

            Text(
                text = "Form Fields >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("FormFieldsScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )

            var text by remember { mutableStateOf(value = "Text") }
            FormField(
                modifier = Modifier.padding(W3WTheme.dimensions.paddingSmall),
                label = "Label",
                value = text,
                onValueChange = { text = it }
            )
            Divider(color = W3WTheme.colors.divider)

            Text(
                text = "Notifications >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("NotificationScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )

            Notification(
                text = "Notification sample text",
                type = NotificationType.Error,
                modifier = Modifier.padding(vertical = W3WTheme.dimensions.paddingSmall)
            )

            Divider(color = W3WTheme.colors.divider)

            Text(
                text = "Buttons >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("ButtonScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )

            PrimaryButton(
                text = "click here to see all button types and sizes",
                buttonSize = ButtonSize.Medium,
                onClick = { navController.navigate("ButtonScreen") },
                modifier = Modifier.padding(start = W3WTheme.dimensions.paddingMedium, bottom = W3WTheme.dimensions.paddingMedium)
            )

            Divider(color = W3WTheme.colors.divider)

            Text(
                text = "IconButtons >",
                modifier = Modifier
                    .padding(
                        top = W3WTheme.dimensions.paddingMedium,
                        start = W3WTheme.dimensions.paddingSmall,
                        end = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall
                    )
                    .clickable {
                        navController.navigate("IconButtonScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.primary,
            )

            Row {
                FilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Medium,
                    onClick = { navController.navigate("IconButtonScreen") },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingMedium
                    )
                )
                GhostFilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Medium,
                    onClick = { navController.navigate("IconButtonScreen") },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingMedium
                    )
                )
                OutlinedIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Medium,
                    onClick = { navController.navigate("IconButtonScreen") },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingMedium
                    )
                )
            }
        }
    }
}