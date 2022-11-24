package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ListItemNavigation(
    title: String,
    modifier: Modifier = Modifier,
    leftIconPainter: Painter? = null,
    iconTint: Color = W3WTheme.colors.primary,
    background: Color = W3WTheme.colors.background,
    titleTextStyle: TextStyle = W3WTheme.typography.headline,
    titleTextColor: Color = W3WTheme.colors.primary,
    showDivider: Boolean = true,
    dividerColor: Color = W3WTheme.colors.divider,
    onClick: (() -> Unit)? = null
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ConstraintLayout(modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = LocalRippleTheme.current.defaultColor()
                ),
                onClick = {
                    onClick?.invoke()
                }
            )
            .background(background)
            .padding(horizontal = W3WTheme.dimensions.paddingSmall, vertical = W3WTheme.dimensions.paddingMedium)
        ) {
            val (icLeft, textTitle, icType) = createRefs()
            if (leftIconPainter != null) {
                Icon(
                    painter = leftIconPainter,
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
                        if (leftIconPainter != null) icLeft.end else parent.start, 8.dp
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
            Icon(
                painter = painterResource(id = if (LocalLayoutDirection.current == LayoutDirection.Rtl) R.drawable.ic_arrow_left else R.drawable.ic_arrow_right),
                contentDescription = stringResource(
                    id = R.string.cd_ic_arrow
                ),
                modifier = Modifier.constrainAs(icType) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                tint = iconTint
            )
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

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun NavigationListItemLight() {
    W3WTheme {
        ListItemNavigation(
            title = "Title",
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun NavigationListItemWithIconLight() {
    W3WTheme {
        ListItemNavigation(
            title = "Contacts",
            leftIconPainter = rememberVectorPainter(image = Icons.Filled.Call),
            onClick = {})
    }
}

@Preview(locale = "ar", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun NavigationListItemWithIconRtlLight() {
    W3WTheme {
        ListItemNavigation(
            title = "جهات الاتصال",
            leftIconPainter = rememberVectorPainter(image = Icons.Filled.Call),
            onClick = {})
    }
}