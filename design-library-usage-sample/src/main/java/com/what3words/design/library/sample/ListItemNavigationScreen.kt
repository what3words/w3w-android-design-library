package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.sample.components.NavigationScaffold
import com.what3words.design.library.ui.components.ListItemNavigation
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ListItemNavigationScreen(navController: NavController) {
    NavigationScaffold(
        title = "ListItemNavigation",
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(W3WTheme.colors.background)
        ) {
            ListItemNavigationExample("Simple ListItemNavigation", "Navigation Item")
            ListItemNavigationExample("Icon ListItemNavigation", "Navigation Item", Icons.Outlined.Star)
            ListItemNavigationExampleRtl("ListItemNavigation right-to-left", "عنصر الملاحة")
        }
    }
}

@Composable
private fun ListItemNavigationExampleRtl(
    title: String,
    navigationTitle: String,
    icon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textFootnote
    )
    Divider(color = Grey40)
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ListItemNavigation(
            title = navigationTitle,
            leftIcon = icon,
            onClick = onClick)
    }
    Divider(color = Grey40)
}

@Composable
private fun ListItemNavigationExample(
    title: String,
    navigationTitle: String,
    icon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textFootnote
    )
    Divider(color = Grey40)
        ListItemNavigation(
            title = navigationTitle,
            leftIcon = icon,
            onClick = onClick)
    Divider(color = Grey40)
}