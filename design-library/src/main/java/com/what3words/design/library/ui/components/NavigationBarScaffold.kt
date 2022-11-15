package com.what3words.design.library.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.what3words.design.library.ui.theme.W3WTheme

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
        bodyContent(it)
    }
}

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
                color = W3WTheme.colors.textSecondary,
                style = W3WTheme.typography.headline
            )
        },
        navigationIcon = navigationIcon,
    )
}