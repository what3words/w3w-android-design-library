package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.FormField
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.components.Notification
import com.what3words.design.library.ui.components.NotificationType
import com.what3words.design.library.ui.theme.PastelGreen
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

    NavigationBarScaffold(
        modifier = Modifier.background(W3WTheme.colors.background),
        title = "FormFields",
        navigationIcon = navigationIcon,
    ) {
        val paddingLarge = W3WTheme.dimensions.paddingLarge
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(W3WTheme.dimensions.paddingSmall)
        ) {
            val (formField1, formField2, formField3, formField4, formField5, title1, errorFormField5) = createRefs()
            var text1 by remember { mutableStateOf(value = "") }
            FormField(modifier = Modifier.constrainAs(formField1) {
                top.linkTo(parent.top, paddingLarge)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
                value = text1,
                enabled = true,
                placeholder = "Placeholder example and no label",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                onValueChange = { text1 = it })
            var text2 by remember { mutableStateOf(value = "Text") }
            FormField(modifier = Modifier.constrainAs(formField2) {
                top.linkTo(formField1.bottom, paddingLarge)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
                label = "Enabled with text",
                value = text2,
                enabled = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                placeholder = "Placeholder text removed",
                onValueChange = { text2 = it })

            FormField(modifier = Modifier.constrainAs(formField3) {
                top.linkTo(formField2.bottom,paddingLarge)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
                label = "Disabled with text",
                value = "This is disabled",
                enabled = false,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                onValueChange = {})

            var text3 by remember { mutableStateOf(value = "حقل النموذج ممكّ") }
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                FormField(modifier = Modifier.constrainAs(formField4) {
                    top.linkTo(formField3.bottom, paddingLarge)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                    label = "ممكن مع الن",
                    value = text3,
                    enabled = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    onValueChange = { text3 = it })
            }

            var text4 by remember { mutableStateOf(value = "") }
            var errorVisible by remember { mutableStateOf(value = false) }
            FormField(modifier = Modifier.constrainAs(formField5) {
                top.linkTo(formField4.bottom, paddingLarge)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
                label = "Form field with action and error message (click info)",
                value = text4,
                enabled = true,
                onValueChange = { text4 = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                action = {
                    IconButton(onClick = {
                        errorVisible = !errorVisible
                    }) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Info),
                            contentDescription = null,
                            tint = W3WTheme.colors.primary
                        )
                    }
                    IconButton(enabled = false, onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = com.what3words.design.library.R.drawable.ic_confirm),
                            contentDescription = null,
                            tint = PastelGreen
                        )
                    }
                })
            Notification(
                modifier = Modifier
                    .constrainAs(errorFormField5) {
                        top.linkTo(formField5.bottom, 4.dp)
                        start.linkTo(formField5.start)
                        end.linkTo(formField5.end)
                    },
                text = "error message example",
                type = NotificationType.Error,
                visible = errorVisible
            )
            Text(
                text = "Some text to make sure error message goes on top",
                modifier = Modifier.constrainAs(title1) {
                    top.linkTo(formField5.bottom, 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
        }
    }
}