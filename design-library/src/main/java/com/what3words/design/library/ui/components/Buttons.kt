package com.what3words.design.library.ui.components

import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.what3words.design.library.ui.theme.W3WTheme

enum class ButtonSize {
    Small,
    Medium,
    Large;

    @Composable
    fun toPaddingVertical(): Dp {
        return when (this) {
            Small -> W3WTheme.dimensions.paddingSmall
            Medium -> W3WTheme.dimensions.paddingSmall
            Large -> W3WTheme.dimensions.paddingLarge
        }
    }

    @Composable
    fun toPaddingHorizontal(): Dp {
        return when (this) {
            Small -> W3WTheme.dimensions.paddingMedium
            Medium -> W3WTheme.dimensions.paddingLarge
            Large -> W3WTheme.dimensions.paddingLarge
        }
    }

    @Composable
    fun toTextStyle(): TextStyle {
        return when (this) {
            Small -> W3WTheme.typography.footnote
            Medium -> W3WTheme.typography.headline
            Large -> W3WTheme.typography.title
        }
    }
}

@Composable
fun PrimaryButton(
    text: String,
    buttonSize: ButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    borderRadius: Dp = W3WTheme.dimensions.borderRadius
) =
    Button(
        text = text,
        backgroundColor = W3WTheme.colors.buttonPrimary,
        backgroundRipple = W3WTheme.colors.buttonPrimaryVariant,
        textColor = W3WTheme.colors.onButtonPrimary,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        icon = icon,
        borderRadius = borderRadius
    )

@Composable
fun SecondaryButton(
    text: String,
    buttonSize: ButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    borderRadius: Dp = W3WTheme.dimensions.borderRadius
) =
    Button(
        text = text,
        backgroundColor = W3WTheme.colors.buttonSecondary,
        backgroundRipple = W3WTheme.colors.buttonSecondaryVariant,
        textColor = W3WTheme.colors.onButtonSecondary,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        icon = icon,
        borderRadius = borderRadius
    )

@Composable
fun TertiaryButton(
    text: String,
    buttonSize: ButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    borderRadius: Dp = W3WTheme.dimensions.borderRadius
) =
    Button(
        text = text,
        backgroundColor = W3WTheme.colors.buttonTertiary,
        backgroundRipple = W3WTheme.colors.buttonTertiaryVariant,
        textColor = W3WTheme.colors.onButtonTertiary,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        icon = icon,
        borderRadius = borderRadius
    )

@Composable
fun TextButton(
    text: String,
    buttonSize: ButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    borderRadius: Dp = W3WTheme.dimensions.borderRadius
) =
    Button(
        text = text,
        backgroundColor = W3WTheme.colors.buttonText,
        backgroundRipple = W3WTheme.colors.buttonTextVariant,
        textColor = W3WTheme.colors.onButtonText,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        icon = icon,
        borderRadius = borderRadius
    )

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Button(
    text: String,
    backgroundColor: Color,
    backgroundRipple: Color,
    buttonSize: ButtonSize,
    textColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: Painter? = null,
    borderRadius: Dp
) {
    var color by remember { mutableStateOf(backgroundColor) }
    ConstraintLayout(
        modifier = modifier
            .clip(RoundedCornerShape(borderRadius))
            .background(color)
            .padding(
                vertical = buttonSize.toPaddingVertical(),
                horizontal = buttonSize.toPaddingHorizontal()
            )
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        color = backgroundRipple
                    }
                    MotionEvent.ACTION_UP -> {
                        color = backgroundColor
                        if (enabled) onClick.invoke()
                    }
                    MotionEvent.AXIS_SIZE -> {
                        color = backgroundColor
                    }
                }
                true
            }
    ) {
        val (iconRef, textRef) = createRefs()
        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.constrainAs(iconRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                tint = textColor
            )
        }
        Text(
            text = text,
            modifier = Modifier.constrainAs(textRef) {
                start.linkTo(
                    if (icon != null) iconRef.end else parent.start,
                    if (icon != null) 8.dp else 0.dp
                )
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            },
            style = buttonSize.toTextStyle(),
            color = textColor,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}