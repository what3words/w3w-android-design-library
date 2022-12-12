package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.FilledIconButton
import com.what3words.design.library.ui.components.GhostFilledIconButton
import com.what3words.design.library.ui.components.IconButtonSize
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.components.OutlinedIconButton
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun IconButtonScreen(navController: NavController) {
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
        title = "Icon Buttons",
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
                text = "FilledIconButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Row {
                FilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Small,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
                FilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Medium,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
                FilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Large,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
            }

            Text(
                text = "GhostFilledIconButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (!isSystemInDarkTheme())
                            W3WTheme.colors.backgroundSecondary else Color.Transparent
                    )
            ) {
                GhostFilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Small,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
                GhostFilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Medium,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
                GhostFilledIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Large,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
            }

            Text(
                text = "OutlinedIconButton",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (!isSystemInDarkTheme())
                            W3WTheme.colors.backgroundSecondary else Color.Transparent
                    )
            ) {
                OutlinedIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Small,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
                OutlinedIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Medium,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
                OutlinedIconButton(
                    icon = painterResource(id = R.drawable.ic_add),
                    buttonSize = IconButtonSize.Large,
                    onClick = { },
                    modifier = Modifier.padding(
                        horizontal = W3WTheme.dimensions.paddingMedium,
                        vertical = W3WTheme.dimensions.paddingSmall
                    )
                )
            }
        }
    }
}