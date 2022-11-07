package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme

enum class ActionListItemType {
    Checkbox, RadioGroup, Toggle
}

@Composable
fun ListItemAction(
    title: String,
    actionListItemType: ActionListItemType,
    isSelected: Boolean,
    onClick: ((Boolean) -> Unit),
    modifier: Modifier = Modifier,
    leftIcon: ImageVector? = null,
    iconTint: Color = W3WTheme.colors.primary,
    background: Color = W3WTheme.colors.background,
    titleTextStyle: TextStyle = W3WTheme.typography.headline,
    titleTextColor: Color = W3WTheme.colors.textPrimary,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clickable(interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = LocalRippleTheme.current.defaultColor()
                ),
                onClick = {
                    onClick.invoke(!isSelected)
                })
            .background(background)
            .padding(W3WTheme.dimensions.paddingSmall)
    ) {
        val (icLeft, textTitle, icType) = createRefs()
        if (leftIcon != null) {
            Icon(
                imageVector = leftIcon,
                contentDescription = null,
                modifier = Modifier.constrainAs(icLeft) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                tint = iconTint
            )
        }
        Text(
            text = title,
            modifier = Modifier.constrainAs(textTitle) {
                start.linkTo(
                    if (leftIcon != null) icLeft.end else parent.start, 8.dp
                )
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            style = titleTextStyle,
            color = titleTextColor,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        IconToggleButton(checked = isSelected,
            onCheckedChange = { onClick.invoke(!isSelected) },
            modifier = Modifier
                .constrainAs(icType) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            when (actionListItemType) {
                ActionListItemType.Checkbox -> CheckboxItem(isSelected)
                ActionListItemType.RadioGroup -> RadioItem(isSelected)
                ActionListItemType.Toggle -> ToggleItem(isSelected)
            }
        }
    }
}

@Composable
private fun RadioItem(isSelected: Boolean) {
    Image(
        painter = painterResource(
            id = when {
                isSelected && isSystemInDarkTheme() -> R.drawable.ic_radio_dark_on
                !isSelected && isSystemInDarkTheme() -> R.drawable.ic_radio_dark_off
                isSelected && !isSystemInDarkTheme() -> R.drawable.ic_radio_light_on
                !isSelected && !isSystemInDarkTheme() -> R.drawable.ic_radio_light_off
                else -> throw Exception("impossible state")
            }
        ), contentDescription = null
    )
}

@Composable
private fun ToggleItem(isSelected: Boolean) {
    Image(
        painter = painterResource(
            id = when {
                isSelected && isSystemInDarkTheme() -> R.drawable.ic_toggle_dark_on
                !isSelected && isSystemInDarkTheme() -> R.drawable.ic_toggle_dark_off
                isSelected && !isSystemInDarkTheme() -> R.drawable.ic_toggle_light_on
                !isSelected && !isSystemInDarkTheme() -> R.drawable.ic_toggle_light_off
                else -> throw Exception("impossible state")
            }
        ), contentDescription = null
    )
}

@Composable
private fun CheckboxItem(isSelected: Boolean) {
    Image(
        painter = painterResource(
            id = when {
                isSelected && isSystemInDarkTheme() -> R.drawable.ic_checkbox_dark_checked
                !isSelected && isSystemInDarkTheme() -> R.drawable.ic_checkbox_dark_unchecked
                isSelected && !isSystemInDarkTheme() -> R.drawable.ic_checkbox_light_checked
                !isSelected && !isSystemInDarkTheme() -> R.drawable.ic_checkbox_light_unchecked
                else -> throw Exception("impossible state")
            }
        ), contentDescription = null
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemCheckboxLightNotSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            actionListItemType = ActionListItemType.Checkbox,
            isSelected = false,
            onClick = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemCheckboxLightSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            actionListItemType = ActionListItemType.Checkbox,
            isSelected = true,
            onClick = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemCheckboxDarkNotSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            actionListItemType = ActionListItemType.Checkbox,
            isSelected = false,
            onClick = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemCheckboxDarkSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            actionListItemType = ActionListItemType.Checkbox,
            isSelected = true,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemToggleLightNotSelected() {
    W3WTheme {
        ListItemAction(title = "Toggle",
            actionListItemType = ActionListItemType.Toggle,
            isSelected = false,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemToggleLightSelected() {
    W3WTheme {
        ListItemAction(title = "Toggle",
            actionListItemType = ActionListItemType.Toggle,
            isSelected = true,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemToggleDarkNotSelected() {
    W3WTheme {
        ListItemAction(
            title = "Toggle",
            actionListItemType = ActionListItemType.Toggle,
            isSelected = false,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemToggleDarkSelected() {
    W3WTheme {
        ListItemAction(
            title = "Toggle",
            actionListItemType = ActionListItemType.Toggle,
            isSelected = true,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemRadioLightNotSelected() {
    W3WTheme {
        ListItemAction(title = "Radio",
            actionListItemType = ActionListItemType.RadioGroup,
            isSelected = false,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemRadioLightSelected() {
    W3WTheme {
        ListItemAction(title = "Toggle",
            actionListItemType = ActionListItemType.RadioGroup,
            isSelected = true,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemRadioDarkNotSelected() {
    W3WTheme {
        ListItemAction(
            title = "Radio",
            actionListItemType = ActionListItemType.RadioGroup,
            isSelected = false,
            onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemRadioDarkSelected() {
    W3WTheme {
        ListItemAction(
            title = "Radio",
            actionListItemType = ActionListItemType.RadioGroup,
            isSelected = true,
            onClick = {})
    }
}