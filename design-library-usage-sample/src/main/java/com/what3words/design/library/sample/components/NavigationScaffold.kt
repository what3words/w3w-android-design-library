package com.what3words.design.library.sample.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun NavigationScaffold(
    title: String? = null,
    navController: NavController? = null,
    bodyContent: @Composable (PaddingValues) -> Unit
) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (navController?.previousBackStackEntry != null) {
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = W3WTheme.colors.primary)
                }
            }
        } else {
            // this can be null or another component
            // If null, the navigationIcon won't be rendered at all
            null
        }


    Scaffold(topBar = {
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