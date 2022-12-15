package com.what3words.design.library.ui.components

import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Dp
import com.what3words.design.library.ui.theme.W3WTheme

enum class IconButtonSize {
    Small,
    Medium,
    Large;

    @Composable
    fun toSize(): Dp {
        return when (this) {
            Small -> W3WTheme.dimensions.iconButtonSmall
            Medium -> W3WTheme.dimensions.iconButtonMedium
            Large -> W3WTheme.dimensions.iconButtonLarge
        }
    }

    @Composable
    fun toPadding(): Dp {
        return when (this) {
            Small -> W3WTheme.dimensions.paddingTiny
            Medium -> W3WTheme.dimensions.paddingSmall
            Large -> W3WTheme.dimensions.paddingSmall
        }
    }
}

/**
 * [FilledIconButton] An What3words styled filled round icon button.
 *
 * @param icon for the [FilledIconButton].
 * @param buttonSize the size desired for the [FilledIconButton] can by any available [IconButtonSize].
 * @param onClick the [FilledIconButton] click event.
 * @param modifier the modifier to be applied to the layout.
 * @param enabled set [FilledIconButton] enabled status, if disabled [onClick] won't be triggered.
 */
@Composable
fun FilledIconButton(
    icon: Painter,
    buttonSize: IconButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) =
    IconButton(
        icon = icon,
        backgroundColor = W3WTheme.colors.buttonPrimary,
        backgroundRipple = W3WTheme.colors.buttonPrimaryVariant,
        textColor = W3WTheme.colors.onButtonPrimary,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    )

/**
 * [GhostFilledIconButton] An What3words styled ghost filled round icon button.
 *
 * @param icon for the [GhostFilledIconButton].
 * @param buttonSize the size desired for the [GhostFilledIconButton] can by any available [IconButtonSize].
 * @param onClick the [GhostFilledIconButton] click event.
 * @param modifier the modifier to be applied to the layout.
 * @param enabled set [GhostFilledIconButton] enabled status, if disabled [onClick] won't be triggered.
 */
@Composable
fun GhostFilledIconButton(
    icon: Painter,
    buttonSize: IconButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) =
    IconButton(
        icon = icon,
        backgroundColor = W3WTheme.colors.buttonOutline,
        backgroundRipple = W3WTheme.colors.buttonOutlineVariant,
        textColor = W3WTheme.colors.onButtonOutline,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    )

/**
 * [OutlinedIconButton] An What3words styled ghost filled round icon button.
 *
 * @param icon for the [OutlinedIconButton].
 * @param buttonSize the size desired for the [OutlinedIconButton] can by any available [IconButtonSize].
 * @param onClick the [OutlinedIconButton] click event.
 * @param modifier the modifier to be applied to the layout.
 * @param enabled set [OutlinedIconButton] enabled status, if disabled [onClick] won't be triggered.
 */
@Composable
fun OutlinedIconButton(
    icon: Painter,
    buttonSize: IconButtonSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) =
    IconButton(
        icon = icon,
        backgroundColor = W3WTheme.colors.buttonText,
        backgroundRipple = W3WTheme.colors.buttonTextVariant,
        textColor = W3WTheme.colors.onButtonText,
        buttonSize = buttonSize,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    )



@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun IconButton(
    icon: Painter,
    backgroundColor: Color,
    backgroundRipple: Color,
    buttonSize: IconButtonSize,
    textColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    var backgroundColorState by remember { mutableStateOf(backgroundColor) }

    Box(modifier = modifier
        .alpha(if (enabled) 1f else 0.5f)
        .size(buttonSize.toSize())
        .clip(CircleShape)
        .background(backgroundColorState)
        .then(
            if (enabled) {
                Modifier.pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            backgroundColorState = backgroundRipple
                        }
                        MotionEvent.ACTION_UP -> {
                            backgroundColorState = backgroundColor
                            if (enabled) onClick.invoke()
                        }
                        MotionEvent.AXIS_SIZE -> {
                            backgroundColorState = backgroundColor
                        }
                    }
                    true
                }
            } else {
                Modifier
            }
        ),
        contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(buttonSize.toPadding()),
            painter = icon,
            contentDescription = null,
            tint = textColor
        )
    }
}
