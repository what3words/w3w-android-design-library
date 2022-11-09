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
        TopAppBar(
            backgroundColor = W3WTheme.colors.background,
            title = {
                Text(
                    text = title.orEmpty(),
                    color = W3WTheme.colors.textPrimary,
                    style = W3WTheme.typography.headline
                )
            },
            navigationIcon = navigationIcon,
        )
    }) {
        bodyContent(it)
    }
}