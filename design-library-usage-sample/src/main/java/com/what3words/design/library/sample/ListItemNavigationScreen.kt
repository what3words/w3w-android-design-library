package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.ListItemNavigation
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ListItemNavigationScreen(navController: NavController) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = W3WTheme.colors.primary)
                }
            }
        } else {
            null
        }

    NavigationBarScaffold(
        title = "ListItemNavigation",
        navigationIcon = navigationIcon
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(W3WTheme.colors.background)
        ) {
            ListItemNavigationExample("Simple ListItemNavigation", "Navigation Item")
            ListItemNavigationExample(
                "Icon ListItemNavigation", "Navigation Item", rememberVectorPainter(
                    image = Icons.Outlined.Star
                )
            )
            ListItemNavigationExampleRtl("ListItemNavigation right-to-left", "عنصر الملاحة")
        }
    }
}

@Composable
private fun ListItemNavigationExampleRtl(
    title: String,
    navigationTitle: String,
    iconPainter: Painter? = null,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textPrimary
    )
    Divider(color = W3WTheme.colors.divider)
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ListItemNavigation(
            title = navigationTitle,
            startIconPainter = iconPainter,
            onClick = onClick
        )
    }
}

@Composable
private fun ListItemNavigationExample(
    title: String,
    navigationTitle: String,
    iconPainter: Painter? = null,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textPrimary
    )
    Divider(color = W3WTheme.colors.divider)
    ListItemNavigation(
        title = navigationTitle,
        startIconPainter = iconPainter,
        onClick = onClick
    )
}