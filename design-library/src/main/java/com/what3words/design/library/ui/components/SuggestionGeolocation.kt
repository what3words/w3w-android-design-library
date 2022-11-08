package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.constraintlayout.compose.Visibility
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun SuggestionGeolocation(
    primaryAddress: String,
    isGeolocationGroup: Boolean,
    modifier: Modifier = Modifier,
    secondaryAddress: String? = null,
    onClick: (() -> Unit)? = null,
    background: Color = W3WTheme.colors.background,
    primaryAddressTextStyle: TextStyle = W3WTheme.typography.headline,
    primaryAddressTextColor: Color = W3WTheme.colors.textPrimary,
    secondaryAddressTextStyle: TextStyle = W3WTheme.typography.caption2,
    secondaryAddressTextColor: Color = W3WTheme.colors.textSecondary,
    iconTint: Color = W3WTheme.colors.primary
) {
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
        .padding(W3WTheme.dimensions.paddingSmall)
    ) {
        val (icGeo, textPrimary, textSecondary, icArrow) = createRefs()

        Icon(
            painter = painterResource(id = if (isGeolocationGroup) R.drawable.ic_geolocation_group else R.drawable.ic_geolocation_single),
            contentDescription = stringResource(id = if (isGeolocationGroup) R.string.cd_ic_geolocation_group else R.string.cd_ic_geolocation_single),
            modifier = Modifier.constrainAs(icGeo) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start, 4.dp)
            },
            tint = iconTint
        )

        Text(
            text = primaryAddress,
            modifier = Modifier.constrainAs(textPrimary) {
                start.linkTo(icGeo.end, 8.dp)
                top.linkTo(parent.top)
                bottom.linkTo(textSecondary.top)
                end.linkTo(icArrow.start)
                width = Dimension.fillToConstraints
            },
            style = primaryAddressTextStyle,
            color = primaryAddressTextColor,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = secondaryAddress.orEmpty(),
            modifier = Modifier.constrainAs(textSecondary) {
                start.linkTo(icGeo.end, 8.dp)
                top.linkTo(textPrimary.bottom)
                bottom.linkTo(parent.bottom)
                end.linkTo(icArrow.start)
                width = Dimension.fillToConstraints
                visibility =
                    if (secondaryAddress.isNullOrEmpty()) Visibility.Gone else Visibility.Visible
            },
            style = secondaryAddressTextStyle,
            color = secondaryAddressTextColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Icon(
            painter = painterResource(id = if (LocalLayoutDirection.current == LayoutDirection.Rtl) R.drawable.ic_arrow_left else R.drawable.ic_arrow_right),
            contentDescription = stringResource(
                id = R.string.cd_ic_arrow
            ),
            modifier = Modifier.constrainAs(icArrow) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                visibility = if (isGeolocationGroup) Visibility.Visible else Visibility.Gone
            },
            tint = iconTint
        )
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GeolocationItemGroupLight() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "Alfred Road",
            secondaryAddress = "London",
            isGeolocationGroup = true,
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GeolocationItemGroupNoSecondaryAddressLight() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "Alfred Road",
            isGeolocationGroup = true,
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GeolocationItemGroupDark() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "Alfred Road",
            secondaryAddress = "London",
            isGeolocationGroup = true,
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GeolocationItemGroupNoSecondaryDark() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "Alfred Road",
            isGeolocationGroup = true,
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GeolocationItemSingleLight() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "What3words, 65 Alfred Road",
            secondaryAddress = "London, W2 5EU",
            isGeolocationGroup = false,
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GeolocationItemSingleNoSecondaryLight() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "What3words, 65 Alfred Road",
            isGeolocationGroup = false,
            onClick = {})
    }
}


@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GeolocationItemSingleDark() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "What3words, 65 Alfred Road",
            secondaryAddress = "London, W2 5EU",
            isGeolocationGroup = false,
            onClick = {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GeolocationItemSingleNoSecondaryDark() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "What3words, 65 Alfred Road",
            isGeolocationGroup = false,
            onClick = {})
    }
}


@Preview(locale = "ar", showBackground = true)
@Composable
fun GeolocationItemSingleRightToLeft() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "ابو فيوض لادوات الصيد",
            secondaryAddress = "المحمودية، سنابادة، مركز المحمودية،، البحيرة 5872461",
            isGeolocationGroup = false,
            onClick = {})
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun GeolocationItemGroupRightToLeft() {
    W3WTheme {
        SuggestionGeolocation(
            primaryAddress = "ابو فيوض لادوات الصيد",
            secondaryAddress = "المحمودية، سنابادة، مركز المحمودية،، البحيرة 5872461",
            isGeolocationGroup = true,
            onClick = {})
    }
}

