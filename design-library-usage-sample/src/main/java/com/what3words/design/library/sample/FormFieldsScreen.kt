package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.FormField
import com.what3words.design.library.ui.components.NavigationBar
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun FormFieldsScreen(navController: NavController) {
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

    NavigationBar(
        title = "FormFields",
        navigationIcon = navigationIcon
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(W3WTheme.colors.background)
        ) {
            var text1 by remember { mutableStateOf(value = "") }
            FormField(modifier = Modifier.padding(
                W3WTheme.dimensions.paddingSmall
            ),
                label = "Enabled with placeholder",
                value = text1,
                enabled = true,
                placeholder = "Placeholder example",
                onValueChange = { text1 = it })
            var text2 by remember { mutableStateOf(value = "Text") }
            FormField(modifier = Modifier.padding(
                W3WTheme.dimensions.paddingSmall
            ),
                label = "Enabled with text",
                value = text2,
                enabled = true,
                placeholder = "Placeholder text removed",
                onValueChange = { text2 = it })

            FormField(modifier = Modifier.padding(
                W3WTheme.dimensions.paddingSmall
            ),
                label = "Disabled with text",
                value = "This is disabled",
                enabled = false,
                onValueChange = {})

            var text3 by remember { mutableStateOf(value = "حقل النموذج ممكّ") }
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                FormField(modifier = Modifier.padding(
                    W3WTheme.dimensions.paddingSmall
                ),
                    label = "ممكن مع الن",
                    value = text3,
                    enabled = true,
                    onValueChange = { text3 = it})
            }
        }
    }
}