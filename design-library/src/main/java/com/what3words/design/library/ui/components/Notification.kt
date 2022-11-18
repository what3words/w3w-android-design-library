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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.what3words.design.library.ui.theme.W3WTheme

enum class NotificationType {
    Success,
    Warning,
    Error
}

@Composable
fun Notification(
    notificationText: String,
    notificationType: NotificationType,
    modifier: Modifier = Modifier,
    visible: Boolean = true,
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
                .background(W3WTheme.colors.backgroundError)
        ) {
            Text(
                text = notificationText,
                modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingSmall,
                    bottom = W3WTheme.dimensions.paddingSmall,
                    start = W3WTheme.dimensions.paddingMedium,
                    end = W3WTheme.dimensions.paddingMedium
                ),
                style = W3WTheme.typography.caption2,
                color = W3WTheme.colors.textError
            )
        }
    }
}