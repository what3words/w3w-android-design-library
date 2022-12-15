package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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

enum class ListItemActionType {
    Checkbox, RadioGroup, Toggle
}

/**
 * [ListItemAction] a list item that contains an action of the type [ListItemActionType.RadioGroup], [ListItemActionType.Checkbox] or [ListItemActionType.Toggle].
 *
 * @param title the title to describe the results of this action.
 * @param listItemActionType define the type of Action this [ListItemAction] will hold, can be [ListItemActionType.RadioGroup], [ListItemActionType.Checkbox] or [ListItemActionType.Toggle].
 * @param isChecked the default state of this action.
 * @param modifier the modifier to be applied to the layout.
 * @param startIconPainter set the start icon of this [ListItemAction] if needed.
 * @param iconTint set the tint [Color] of [startIconPainter].
 * @param background set the background [Color] of the [ListItemAction].
 * @param titleTextStyle set [TextStyle] of the [title].
 * @param titleTextColor set text [Color] of the [title].
 * @param showDivider if using on a list and you want to show a [Divider].
 * @param dividerColor the color of the [Divider].
 * @param onCheckedChange click callback [ListItemAction] is state is changed.
 */
@Composable
fun ListItemAction(
    title: String,
    listItemActionType: ListItemActionType,
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    startIconPainter: Painter? = null,
    iconTint: Color = W3WTheme.colors.primary,
    background: Color = W3WTheme.colors.background,
    titleTextStyle: TextStyle = W3WTheme.typography.headline,
    titleTextColor: Color = W3WTheme.colors.primary,
    showDivider: Boolean = true,
    dividerColor: Color = W3WTheme.colors.divider,
    onCheckedChange: ((Boolean) -> Unit)
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ConstraintLayout(
            modifier = modifier
                .fillMaxWidth()
                .clickable(interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(
                        color = LocalRippleTheme.current.defaultColor()
                    ),
                    onClick = {
                        onCheckedChange.invoke(!isChecked)
                    })
                .background(background)
                .padding(start = W3WTheme.dimensions.paddingSmall, top = W3WTheme.dimensions.paddingTiny, bottom = W3WTheme.dimensions.paddingTiny, end = W3WTheme.dimensions.paddingTiny)
        ) {
            val (icLeft, textTitle, icType) = createRefs()
            if (startIconPainter != null) {
                Icon(
                    painter = startIconPainter,
                    contentDescription = null,
                    modifier = Modifier.constrainAs(icLeft) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, 4.dp)
                    },
                    tint = iconTint
                )
            }
            Text(
                text = title,
                modifier = Modifier.constrainAs(textTitle) {
                    start.linkTo(
                        if (startIconPainter != null) icLeft.end else parent.start, 8.dp
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
            IconToggleButton(checked = isChecked,
                onCheckedChange = { onCheckedChange.invoke(!isChecked) },
                modifier = Modifier
                    .constrainAs(icType) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                when (listItemActionType) {
                    ListItemActionType.Checkbox -> CheckboxItem(isChecked)
                    ListItemActionType.RadioGroup -> RadioItem(isChecked)
                    ListItemActionType.Toggle -> ToggleItem(isChecked)
                }
            }
        }
        if (showDivider) {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = dividerColor,
                thickness = W3WTheme.dimensions.divider
            )
        }
    }
}

@Composable
private fun RadioItem(isChecked: Boolean) {
    Image(
        painter = painterResource(
            id = when {
                isChecked && isSystemInDarkTheme() -> R.drawable.ic_radio_dark_on
                !isChecked && isSystemInDarkTheme() -> R.drawable.ic_radio_dark_off
                isChecked && !isSystemInDarkTheme() -> R.drawable.ic_radio_light_on
                !isChecked && !isSystemInDarkTheme() -> R.drawable.ic_radio_light_off
                else -> throw Exception("impossible state")
            }
        ), contentDescription = null
    )
}

@Composable
private fun ToggleItem(isChecked: Boolean) {
    Image(
        painter = painterResource(
            id = when {
                isChecked && isSystemInDarkTheme() -> R.drawable.ic_toggle_dark_on
                !isChecked && isSystemInDarkTheme() -> R.drawable.ic_toggle_dark_off
                isChecked && !isSystemInDarkTheme() -> R.drawable.ic_toggle_light_on
                !isChecked && !isSystemInDarkTheme() -> R.drawable.ic_toggle_light_off
                else -> throw Exception("impossible state")
            }
        ), contentDescription = null
    )
}

@Composable
private fun CheckboxItem(isChecked: Boolean) {
    Image(
        painter = painterResource(
            id = when {
                isChecked && isSystemInDarkTheme() -> R.drawable.ic_checkbox_dark_checked
                !isChecked && isSystemInDarkTheme() -> R.drawable.ic_checkbox_dark_unchecked
                isChecked && !isSystemInDarkTheme() -> R.drawable.ic_checkbox_light_checked
                !isChecked && !isSystemInDarkTheme() -> R.drawable.ic_checkbox_light_unchecked
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
            listItemActionType = ListItemActionType.Checkbox,
            isChecked = false,
            onCheckedChange = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemCheckboxLightSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            listItemActionType = ListItemActionType.Checkbox,
            isChecked = true,
            onCheckedChange = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemCheckboxDarkNotSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            listItemActionType = ListItemActionType.Checkbox,
            isChecked = false,
            onCheckedChange = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemCheckboxDarkSelected() {
    W3WTheme {
        ListItemAction(title = "Checkbox",
            listItemActionType = ListItemActionType.Checkbox,
            isChecked = true,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemToggleLightNotSelected() {
    W3WTheme {
        ListItemAction(title = "Toggle",
            listItemActionType = ListItemActionType.Toggle,
            isChecked = false,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemToggleLightSelected() {
    W3WTheme {
        ListItemAction(title = "Toggle",
            listItemActionType = ListItemActionType.Toggle,
            isChecked = true,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemToggleDarkNotSelected() {
    W3WTheme {
        ListItemAction(
            title = "Toggle",
            listItemActionType = ListItemActionType.Toggle,
            isChecked = false,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemToggleDarkSelected() {
    W3WTheme {
        ListItemAction(
            title = "Toggle",
            listItemActionType = ListItemActionType.Toggle,
            isChecked = true,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemRadioLightNotSelected() {
    W3WTheme {
        ListItemAction(title = "Radio",
            listItemActionType = ListItemActionType.RadioGroup,
            isChecked = false,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ActionListItemRadioLightSelected() {
    W3WTheme {
        ListItemAction(title = "Toggle",
            listItemActionType = ListItemActionType.RadioGroup,
            isChecked = true,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemRadioDarkNotSelected() {
    W3WTheme {
        ListItemAction(
            title = "Radio",
            listItemActionType = ListItemActionType.RadioGroup,
            isChecked = false,
            onCheckedChange = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ActionListItemRadioDarkSelected() {
    W3WTheme {
        ListItemAction(
            title = "Radio",
            listItemActionType = ListItemActionType.RadioGroup,
            isChecked = true,
            onCheckedChange = {})
    }
}