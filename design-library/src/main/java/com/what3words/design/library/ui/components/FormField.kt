package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.Grey30
import com.what3words.design.library.ui.theme.Grey45
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun FormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: String? = null,
) {
    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        textStyle = W3WTheme.typography.body.copy(color = W3WTheme.colors.textSecondary),
        onValueChange = onValueChange,
        enabled = enabled,
        maxLines = 1,
        singleLine = true,
        cursorBrush = SolidColor(W3WTheme.colors.textSecondary),
        decorationBox = { innerTextField ->
            Column {
                Text(
                    text = label,
                    style = W3WTheme.typography.caption1,
                    color = W3WTheme.colors.textPrimary,
                )
                Spacer(modifier = Modifier.height(2.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(if (enabled) W3WTheme.colors.background else W3WTheme.colors.backgroundDisabled)
                        .border(1.dp, Grey30)
                        .padding(W3WTheme.dimensions.paddingMedium)
                ) {
                    if (value.isEmpty() && placeholder != null) {
                        Text(
                            text = placeholder,
                            style = W3WTheme.typography.body.copy(color = Grey45)
                        )
                    }
                    innerTextField()
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
        FormField(label = "Enabled with placeholder",
            value = "",
            enabled = true,
            placeholder = "Placeholder example",
            onValueChange = { _ -> })
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