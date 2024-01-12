package com.what3words.design.library.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

internal const val TEXT_SCALE_REDUCTION_INTERVAL = 0.9f

/**
 * Composable function to display responsive text that can adapt its size based on the container.
 *
 * @param modifier The [Modifier] to be applied to this layout.
 * @param text The text to be displayed.
 * @param color The color to apply to the text.
 * @param textAlign Alignment of the text (default is [TextAlign.Center]).
 * @param textStyle The style to apply to the text (font, fontWeight, etc.).
 * @param targetTextSizeHeight The target size of the text, defaults to the font size defined in [textStyle].
 * @param resizeFunc Optional function to be called when the text needs to resize due to overflowing.
 * @param maxLines Maximum number of lines the text can occupy, default is 1.
 *
 * This function creates a [Text] composable that automatically adjusts its size if the text overflows
 * and the [resizeFunc] is provided. It's useful for creating text elements that need to respond to
 * container size changes or dynamic content adjustments. The function respects the maxLines parameter,
 * truncating the text with an ellipsis if it exceeds the specified line count.
 */
@Composable
internal fun ResponsiveText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textAlign: TextAlign = TextAlign.Center,
    textStyle: TextStyle,
    targetTextSizeHeight: TextUnit = textStyle.fontSize,
    resizeFunc: (() -> Unit)? = null,
    maxLines: Int = 1,
) {

    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontSize = targetTextSizeHeight,
        fontFamily = textStyle.fontFamily,
        fontStyle = textStyle.fontStyle,
        fontWeight = textStyle.fontWeight,
        lineHeight = textStyle.lineHeight,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

            if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                resizeFunc?.invoke()
            }
        },
    )
}