package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.what3words.design.library.ui.theme.W3WTheme

/**
 * [FormField] A TextField to be used in What3words apps and demo apps that can be easily styled to look highly integrated within any app.
 *
 * @param value the [FormField] text value.
 * @param modifier the modifier to be applied to the layout.
 * @param label the label to describe what information this [FormField] holds or is expected to be typed in, this label will be shown on the top left of the [FormField].
 * @param enabled enable or disabled [FormField] text input.
 * @param placeholder the placeholder to be shown when no text is added to the [FormField].
 * @param labelTextStyle the [TextStyle] for the [label] shown on the top left of the [FormField].
 * @param labelTextColor the text [Color] for the [label] shown on the top left of the [FormField].
 * @param valueTextStyle the [TextStyle] for the text inside of the [FormField].
 * @param valueTextColor the text [Color] for the text inside of the [FormField].
 * @param placeHolderTextColor the text [Color] for the [placeholder] inside of the [FormField].
 * @param valueEnabledBackgroundColor the background [Color] for the [FormField] when [enabled] is true.
 * @param valueDisabledBackgroundColor the background [Color] for the [FormField] when [enabled] is false.
 * @param borderRadius border radius for [FormField] in [dp].
 * @param borderColor border [Color] for [FormField].
 * @param borderThickness border thickness for [FormField] in [dp].
 * @param action a [Row] of actions buttons to be applied to the [FormField], i.e: multiple [IconButton].
 * @param focusManager allows to set a custom [FocusManager] to handle focus in a screen.
 * @param keyboardOptions set [KeyboardOptions] on [FormField].
 * @param keyboardActions set [KeyboardActions] on [FormField].
 * @param onValueChange when [value] is changed this callback will be called with the updated text.
 */
@Composable
fun FormField(
    value: String,
    modifier: Modifier = Modifier,
    label: String? = null,
    enabled: Boolean = true,
    placeholder: String? = null,
    labelTextStyle: TextStyle = W3WTheme.typography.caption1,
    labelTextColor: Color = W3WTheme.colors.primary,
    valueTextStyle: TextStyle = W3WTheme.typography.body,
    valueTextColor: Color = W3WTheme.colors.textPrimary,
    placeHolderTextColor: Color = W3WTheme.colors.textPlaceholder,
    valueEnabledBackgroundColor: Color = W3WTheme.colors.background,
    valueDisabledBackgroundColor: Color = W3WTheme.colors.backgroundDisabled,
    borderRadius: Dp = W3WTheme.dimensions.borderRadius,
    borderColor: Color = W3WTheme.colors.border,
    borderThickness: Dp = W3WTheme.dimensions.borderThickness,
    action: (@Composable () -> Unit)? = null,
    focusManager: FocusManager = LocalFocusManager.current,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions = KeyboardActions(
        onDone = { focusManager.clearFocus(true)},
        onNext = {
            if (!focusManager.moveFocus(FocusDirection.Down)) {
                focusManager.clearFocus(true)
            }
        }
    ),
    onValueChange: (String) -> Unit
) {

    BasicTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        textStyle = valueTextStyle.copy(color = valueTextColor),
        onValueChange = onValueChange,
        enabled = enabled,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        cursorBrush = SolidColor(valueTextColor),
        decorationBox = { innerTextField ->
            Column(modifier = modifier.fillMaxWidth()) {
                if (label?.isNotEmpty() == true) {
                    Text(
                        text = label,
                        style = labelTextStyle,
                        color = labelTextColor,
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(borderRadius))
                        .background(if (enabled) valueEnabledBackgroundColor else valueDisabledBackgroundColor)
                        .border(
                            borderThickness,
                            borderColor,
                            RoundedCornerShape(borderRadius)
                        )
                ) {
                    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                        val (boxValue, rowActions) = createRefs()
                        Box(modifier = Modifier
                            .constrainAs(boxValue) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(rowActions.start, 8.dp)
                                width = Dimension.fillToConstraints
                            }
                            .padding(
                                top = W3WTheme.dimensions.paddingLarge,
                                bottom = W3WTheme.dimensions.paddingLarge,
                                start = W3WTheme.dimensions.paddingLarge,
                            )) {
                            if (value.isEmpty() && placeholder != null) {
                                Text(
                                    text = placeholder,
                                    style = valueTextStyle.copy(color = placeHolderTextColor)
                                )
                            }
                            innerTextField()
                        }
                        Row(modifier = Modifier.constrainAs(rowActions) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end, 8.dp)
                            height = Dimension.fillToConstraints
                        }, verticalAlignment = Alignment.CenterVertically) {
                            action?.invoke()
                        }
                    }
                }
            }
        }
    )
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true,
    locale = "en"
)
@Composable
fun FormFieldLightEnabledWithPlaceholder() {
    W3WTheme {
        FormField(
            label = "Enabled with placeholder",
            value = "",
            enabled = true,
            placeholder = "Placeholder example",
            onValueChange = { _ -> },
            action = {
                IconButton(onClick = {

                }) {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Filled.ArrowBack),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {

                }) {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Filled.Add),
                        contentDescription = null
                    )
                }
            }
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true,
    locale = "en"
)
@Composable
fun FormFieldLightDisabledWithText() {
    W3WTheme {
        FormField(label = "Disabled with text",
            value = "Disabled form field",
            enabled = false,
            placeholder = "Placeholder example",
            onValueChange = { _ -> })
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true,
    locale = "en"
)
@Composable
fun FormFieldLightEnabledWithText() {
    W3WTheme {
        FormField(label = "Enabled with text",
            value = "Enabled form field",
            enabled = true,
            placeholder = "Placeholder example",
            onValueChange = { _ -> })
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFFD6D6D6,
    locale = "en"
)
@Composable
fun FormFieldNightEnabledWithText() {
    W3WTheme {
        FormField(label = "Enabled with placeholder",
            value = "Enabled form field",
            enabled = true,
            placeholder = "Placeholder example",
            onValueChange = { _ -> })
    }
}

@Preview(locale = "ar", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun FormFieldLightEnabledWithTextRtl() {
    W3WTheme {
        FormField(label = "ممكن مع الن",
            value = "حقل النموذج ممكّ",
            enabled = true,
            onValueChange = { _ -> })
    }
}