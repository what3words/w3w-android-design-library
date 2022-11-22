package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.components.Notification
import com.what3words.design.library.ui.components.NotificationType
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun NotificationScreen(navController: NavController) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = W3WTheme.colors.primary
                    )
                }
            }
        } else {
            null
        }

    NavigationBarScaffold(
        modifier = Modifier.background(W3WTheme.colors.background),
        title = "Notification",
        navigationIcon = navigationIcon,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = W3WTheme.dimensions.paddingSmall,
                    bottom = W3WTheme.dimensions.paddingSmall
                )
        ) {
            NotificationExample(
                "Notification error with icon",
                "Notification sample text",
                NotificationType.Error,
                true
            )
            NotificationExample(
                "Notification error without icon",
                "Notification sample text",
                NotificationType.Error,
                false
            )
            NotificationExampleRtl(
                "Notification error with icon right-to-left",
                "نص نموذج للإخطار",
                NotificationType.Error,
                true
            )
            NotificationExampleRtl(
                "Notification error without icon right-to-left",
                "نص نموذج للإخطار",
                NotificationType.Error,
                false
            )
            NotificationExample(
                "Notification warning with icon",
                "Notification sample text",
                NotificationType.Warning,
                true
            )
            NotificationExample(
                "Notification warning without icon",
                "Notification sample text",
                NotificationType.Warning,
                false
            )
            NotificationExample(
                "Notification confirmation with icon",
                "Notification sample text",
                NotificationType.Confirmation,
                true
            )
            NotificationExample(
                "Notification confirmation without icon",
                "Notification sample text",
                NotificationType.Confirmation,
                false
            )
            Spacer(modifier = Modifier.height(W3WTheme.dimensions.paddingSmall))
            NotificationExample(
                "Notification information with icon",
                "Notification sample text",
                NotificationType.Information,
                true
            )
            NotificationExample(
                "Notification information without icon",
                "Notification sample text",
                NotificationType.Information,
                false
            )
        }
    }
}

@Composable
private fun NotificationExampleRtl(
    title: String,
    notificationTitle: String,
    notificationType: NotificationType,
    withIcon: Boolean
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textPrimary
    )
    Divider(color = W3WTheme.colors.divider)
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Notification(
            text = notificationTitle,
            type = notificationType,
            withIcon = withIcon
        )
    }
}

@Composable
private fun NotificationExample(
    title: String,
    notificationTitle: String,
    notificationType: NotificationType,
    withIcon: Boolean
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textPrimary
    )
    Notification(
        text = notificationTitle,
        type = notificationType,
        withIcon = withIcon
    )
}