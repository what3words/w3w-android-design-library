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
import com.what3words.design.library.sample.components.NavigationScaffold
import com.what3words.design.library.ui.components.ActionListItemType
import com.what3words.design.library.ui.components.ListItemAction
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ListItemActionScreen(navController: NavController) {
    NavigationScaffold(
        title = "ListItemActionScreen",
        navController = navController
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
            ListItemActionExample(
                descriptionTitle = "ListItemAction using Checkbox",
                itemTitle = "Checkbox",
                type = ActionListItemType.Checkbox,
                stateValue = checkbox1,
                onClick = { isChecked -> checkbox1 = isChecked }
            )
            Text(
                text = "ListItemAction using Checkbox with left Icon",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textFootnote
            )
            Divider(color = Grey40)
            ListItemAction(
                title = "Checkbox",
                leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Check),
                actionListItemType = ActionListItemType.Checkbox,
                isSelected = checkbox2,
                onClick = { isChecked -> checkbox2 = isChecked })
            Divider(color = Grey40)
            Text(
                text = "ListItemAction using Toggle",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textFootnote
            )
            Divider(color = Grey40)
            ListItemAction(
                title = "Toggle",
                actionListItemType = ActionListItemType.Toggle,
                isSelected = toggle1,
                onClick = { isOn -> toggle1 = isOn })
            Divider(color = Grey40)
            Text(
                text = "ListItemAction using Toggle with left Icon",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textFootnote
            )
            Divider(color = Grey40)
            ListItemAction(
                title = "Toggle",
                leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Star),
                actionListItemType = ActionListItemType.Toggle,
                isSelected = toggle2,
                onClick = { isOn ->
                    toggle2 = isOn
                })
            Divider(color = Grey40)
            Text(
                text = "ListItemAction using multiple RadioGroup",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textFootnote
            )
            Divider(color = Grey40)
            ListItemAction(
                title = "Radio 1",
                actionListItemType = ActionListItemType.RadioGroup,
                isSelected = radio == 1,
                onClick = { isOn ->
                    if (isOn) radio = 1
                })
            Divider(color = Grey40)
            ListItemAction(
                title = "Radio 2",
                actionListItemType = ActionListItemType.RadioGroup,
                isSelected = radio == 2,
                onClick = { isOn ->
                    if (isOn) radio = 2
                })
            Divider(color = Grey40)
            ListItemAction(
                title = "Radio 3",
                actionListItemType = ActionListItemType.RadioGroup,
                isSelected = radio == 3,
                onClick = { isOn ->
                    if (isOn) radio = 3
                })
            Divider(color = Grey40)
            Text(
                text = "ListItemAction using Checkbox with Icon on right-to-left locale",
                modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textFootnote
            )
            Divider(color = Grey40)
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                ListItemAction(
                    title = "خانة اختيار",
                    leftIconPainter = rememberVectorPainter(image = Icons.Outlined.Check),
                    actionListItemType = ActionListItemType.Checkbox,
                    isSelected = checkbox3,
                    onClick = { isChecked -> checkbox3 = isChecked })
            }
            Divider(color = Grey40)
        }
    }
}

@Composable
private fun ListItemActionExample(
    descriptionTitle: String,
    itemTitle: String,
    type: ActionListItemType,
    stateValue: Boolean,
    onClick: (Boolean) -> Unit
) {
    Text(
        text = descriptionTitle,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textFootnote
    )
    Divider(color = Grey40)
    ListItemAction(
        title = itemTitle,
        actionListItemType = type,
        isSelected = stateValue,
        onClick = onClick
    )
    Divider(color = Grey40)
}