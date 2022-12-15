package com.what3words.design.library.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme

/**
 * [NavigationBarScaffold] a what3words styled [TopAppBar] within a [Scaffold] with [bodyContent].
 *
 * @param modifier the modifier to be applied to the layout.
 * @param title the title of this [NavigationBar].
 * @param navigationIcon sets the navigation icon of this [NavigationBar].
 * @param bodyContent sets the content of the [Scaffold].
 */
@Composable
fun NavigationBarScaffold(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    bodyContent: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(modifier = modifier, topBar = {
        NavigationBar(modifier = Modifier, title, navigationIcon)
    }) {
        Column(modifier = modifier.fillMaxWidth()) {
            if (isSystemInDarkTheme()) Divider(color = W3WTheme.colors.divider)
            bodyContent(it)
        }
    }
}

/**
 * [NavigationBar] a what3words styled [TopAppBar].
 *
 * @param modifier the modifier to be applied to the layout.
 * @param title the title of this [NavigationBar].
 * @param navigationIcon sets the navigation icon of this [NavigationBar].
 */
@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    navigationIcon: (@Composable () -> Unit)? = null
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = W3WTheme.colors.background,
        title = {
            Text(
                text = title.orEmpty(),
                color = W3WTheme.colors.primary,
                style = W3WTheme.typography.headline
            )
        },
        navigationIcon = navigationIcon,
        elevation = if (isSystemInDarkTheme()) 0.dp else W3WTheme.dimensions.appBarElevation
    )
}