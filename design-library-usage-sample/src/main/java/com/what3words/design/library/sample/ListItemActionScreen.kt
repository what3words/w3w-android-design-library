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
import com.what3words.design.library.ui.components.ActionListItemType
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
                actionListItemType = ActionListItemType.Checkbox,
                isSelected = checkbox1,
                onClick = { isChecked -> checkbox1 = isChecked })
            Text(
                text = "ListItemAction using Checkbox with left Icon",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Checkbox",
                leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Check),
                actionListItemType = ActionListItemType.Checkbox,
                isSelected = checkbox2,
                onClick = { isChecked -> checkbox2 = isChecked })
            Text(
                text = "ListItemAction using Toggle",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Toggle",
                actionListItemType = ActionListItemType.Toggle,
                isSelected = toggle1,
                onClick = { isOn -> toggle1 = isOn })
            Text(
                text = "ListItemAction using Toggle with left Icon",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )
            Divider(color = W3WTheme.colors.divider)
            ListItemAction(
                title = "Toggle",
                leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Star),
                actionListItemType = ActionListItemType.Toggle,
                isSelected = toggle2,
                onClick = { isOn ->
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
                actionListItemType = ActionListItemType.RadioGroup,
                isSelected = radio == 1,
                onClick = { isOn ->
                    if (isOn) radio = 1
                })
            ListItemAction(
                title = "Radio 2",
                actionListItemType = ActionListItemType.RadioGroup,
                isSelected = radio == 2,
                onClick = { isOn ->
                    if (isOn) radio = 2
                })
            ListItemAction(
                title = "Radio 3",
                actionListItemType = ActionListItemType.RadioGroup,
                isSelected = radio == 3,
                onClick = { isOn ->
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
                    leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Check),
                    actionListItemType = ActionListItemType.Checkbox,
                    isSelected = checkbox3,
                    onClick = { isChecked -> checkbox3 = isChecked })
            }
        }
    }
}