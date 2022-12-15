package com.what3words.design.library.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme

enum class NotificationType {
    Confirmation,
    Information,
    Warning,
    Error
}

/**
 * [Notification] a list item that contains a what3words address information.
 *
 * @param text the text to be shown in this [Notification].
 * @param type the [NotificationType] of [Notification], it can be either [NotificationType.Information] or [NotificationType.Error] or [NotificationType.Warning] or [NotificationType.Confirmation].
 * @param modifier the modifier to be applied to the layout.
 * @param visible sets the visibility of this [Notification].
 * @param withIcon sets the visibility of the [Notification] icon.
 * @param textColor set [TextStyle] of the [Notification].
 * @param iconTint set [Color] of the [Notification] icon.
 */
@Composable
fun Notification(
    text: String,
    type: NotificationType,
    modifier: Modifier = Modifier,
    visible: Boolean = true,
    withIcon: Boolean = true,
    textColor: Color = W3WTheme.colors.textNotification,
    iconTint: Color = W3WTheme.colors.textNotification
) {
    AnimatedVisibility(
        visible = visible,
        modifier = modifier.zIndex(Float.MAX_VALUE),
        enter = fadeIn(
            animationSpec = tween(
                easing = LinearEasing
            ),
        ),
        exit = fadeOut(
            animationSpec = tween(
                easing = LinearEasing
            )
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    when (type) {
                        NotificationType.Confirmation -> W3WTheme.colors.backgroundConfirmation
                        NotificationType.Information -> W3WTheme.colors.backgroundInformation
                        NotificationType.Warning -> W3WTheme.colors.backgroundWarning
                        NotificationType.Error -> W3WTheme.colors.backgroundError
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (withIcon) {
                Icon(
                    modifier = Modifier.padding(
                        top = W3WTheme.dimensions.paddingSmall,
                        bottom = W3WTheme.dimensions.paddingSmall,
                        start = W3WTheme.dimensions.paddingMedium
                    ),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null,
                    tint = iconTint
                )
            }
            Text(
                text = text,
                modifier = Modifier.padding(
                    vertical = W3WTheme.dimensions.paddingSmall,
                    horizontal = W3WTheme.dimensions.paddingMedium
                ),
                style = W3WTheme.typography.caption2,
                color = textColor
            )
        }
    }
}

@Preview(locale = "en")
@Composable
fun NotificationErrorWithIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Error
        )
    }
}

@Preview(locale = "en")
@Composable
fun NotificationErrorWithoutIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Error,
            withIcon = false
        )
    }
}

@Preview(locale = "en")
@Composable
fun NotificationWarningWithIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Warning
        )
    }
}

@Preview(locale = "en")
@Composable
fun NotificationWarningWithoutIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Warning,
            withIcon = false
        )
    }
}

@Preview(locale = "en")
@Composable
fun NotificationConfirmationWithIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Confirmation
        )
    }
}

@Preview(locale = "en")
@Composable
fun NotificationConfirmationWithoutIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Confirmation,
            withIcon = false
        )
    }
}


@Preview(locale = "en")
@Composable
fun NotificationInformationWithIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Information
        )
    }
}

@Preview(locale = "en")
@Composable
fun NotificationInformationWithoutIcon() {
    W3WTheme {
        Notification(
            text = "Notification sample text",
            type = NotificationType.Information,
            withIcon = false
        )
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun NotificationInformationWithIconRtl() {
    W3WTheme {
        Notification(
            text = "نص نموذج للإخطار",
            type = NotificationType.Information,
            withIcon = true
        )
    }
}