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
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.ListItemActionType
import com.what3words.design.library.ui.components.ListItemAction
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ListItemActionScreen(navController: NavController) {
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
        title = "ListItemActionScreen",
        navigationIcon = navigationIcon
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(W3WTheme.colors.background)
        ) {
            var checkbox1 by remember { mutableStateOf(value = false) }
            var checkbox2 by remember { mutableStateOf(value = false) }
            var checkbox3 by remember { mutableStateOf(value = false) }
            var toggle1 by remember { mutableStateOf(value = false) }
            var toggle2 by remember { mutableStateOf(value = false) }
            var radio by remember { mutableStateOf(value = 1) }
            Text(
                text = "ListItemAction using Checkbox",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Checkbox",
                listItemActionType = ListItemActionType.Checkbox,
                isChecked = checkbox1,
                onCheckedChange = { isChecked -> checkbox1 = isChecked })
            Text(
                text = "ListItemAction using Checkbox with left Icon",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Checkbox",
                startIconPainter = rememberVectorPainter(image = Icons.Outlined.Check),
                listItemActionType = ListItemActionType.Checkbox,
                isChecked = checkbox2,
                onCheckedChange = { isChecked -> checkbox2 = isChecked })
            Text(
                text = "ListItemAction using Toggle",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Toggle",
                listItemActionType = ListItemActionType.Toggle,
                isChecked = toggle1,
                onCheckedChange = { isOn -> toggle1 = isOn })
            Text(
                text = "ListItemAction using Toggle with left Icon",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Toggle",
                startIconPainter = rememberVectorPainter(image = Icons.Outlined.Star),
                listItemActionType = ListItemActionType.Toggle,
                isChecked = toggle2,
                onCheckedChange = { isOn ->
                    toggle2 = isOn
                })
            Text(
                text = "ListItemAction using multiple RadioGroup",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Radio 1",
                listItemActionType = ListItemActionType.RadioGroup,
                isChecked = radio == 1,
                onCheckedChange = { isOn ->
                    if (isOn) radio = 1
                })
            ListItemAction(
                title = "Radio 2",
                listItemActionType = ListItemActionType.RadioGroup,
                isChecked = radio == 2,
                onCheckedChange = { isOn ->
                    if (isOn) radio = 2
                })
            ListItemAction(
                title = "Radio 3",
                listItemActionType = ListItemActionType.RadioGroup,
                isChecked = radio == 3,
                onCheckedChange = { isOn ->
                    if (isOn) radio = 3
                })
            Text(
                text = "ListItemAction using Checkbox with Icon on right-to-left locale",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                ListItemAction(
                    title = "خانة اختيار",
                    startIconPainter = rememberVectorPainter(image = Icons.Outlined.Check),
                    listItemActionType = ListItemActionType.Checkbox,
                    isChecked = checkbox3,
                    onCheckedChange = { isChecked -> checkbox3 = isChecked })
            }
        }
    }
}