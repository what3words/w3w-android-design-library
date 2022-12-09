package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.ButtonSize
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.components.PrimaryButton
import com.what3words.design.library.ui.components.SecondaryButton
import com.what3words.design.library.ui.components.TertiaryButton
import com.what3words.design.library.ui.components.TextButton
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ButtonScreen(navController: NavController) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = W3WTheme.colors.primary
                    )
                }
            }
        } else {
            null
        }

    NavigationBarScaffold(
        modifier = Modifier.background(W3WTheme.colors.background),
        title = "Buttons",
        navigationIcon = navigationIcon,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = W3WTheme.dimensions.paddingSmall,
                    bottom = W3WTheme.dimensions.paddingSmall
                )
        ) {
            Text(
                text = "PrimaryButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            PrimaryButton(
                text = "small primary button",
                buttonSize = ButtonSize.Small,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            PrimaryButton(
                text = "medium primary button with icon",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                ),
                icon = rememberVectorPainter(image = Icons.Default.Info)
            )
            PrimaryButton(
                text = "large primary button",
                buttonSize = ButtonSize.Large,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            PrimaryButton(
                text = "medium primary button with fillMaxWidth",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier
                    .padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                    .fillMaxWidth()
            )

            Text(
                text = "SecondaryButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            SecondaryButton(
                text = "small secondary button",
                buttonSize = ButtonSize.Small,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            SecondaryButton(
                text = "medium secondary button with icon",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                ),
                icon = rememberVectorPainter(image = Icons.Default.Info)
            )
            SecondaryButton(
                text = "large secondary button",
                buttonSize = ButtonSize.Large,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            SecondaryButton(
                text = "medium secondary button with fillMaxWidth",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier
                    .padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                    .fillMaxWidth()
            )

            Text(
                text = "TertiaryButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            TertiaryButton(
                text = "small tertiary button",
                buttonSize = ButtonSize.Small,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            TertiaryButton(
                text = "medium tertiary button with icon",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                ),
                icon = rememberVectorPainter(image = Icons.Default.Info)
            )
            TertiaryButton(
                text = "large tertiary button",
                buttonSize = ButtonSize.Large,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            TertiaryButton(
                text = "medium tertiary button with fillMaxWidth",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier
                    .padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                    .fillMaxWidth()
            )

            Text(
                text = "TextButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            TextButton(
                text = "small text button",
                buttonSize = ButtonSize.Small,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            TextButton(
                text = "medium text button with icon",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                ),
                icon = rememberVectorPainter(image = Icons.Default.Info)
            )
            TextButton(
                text = "large text button",
                buttonSize = ButtonSize.Large,
                onClick = { },
                modifier = Modifier.padding(
                    horizontal = W3WTheme.dimensions.paddingMedium,
                    vertical = W3WTheme.dimensions.paddingSmall
                )
            )
            TextButton(
                text = "medium text button with fillMaxWidth",
                buttonSize = ButtonSize.Medium,
                onClick = { },
                modifier = Modifier
                    .padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                    .fillMaxWidth()
            )
        }
    }
}