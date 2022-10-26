package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.Grey50
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun GeolocationItem(
    primaryAddress: String,
    secondaryAddress: String,
    isGeolocationGroup: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .background(MaterialTheme.colors.background)
        .padding(dimensionResource(id = R.dimen.normal_100))
    ) {
        val (icGeo, textPrimary, textSecondary, icArrow) = createRefs()

        Icon(
            painter = painterResource(id = if (isGeolocationGroup) R.drawable.ic_geolocation_group else R.drawable.ic_geolocation_single),
            contentDescription = stringResource(id = if (isGeolocationGroup) R.string.cd_ic_geolocation_group else R.string.cd_ic_geolocation_single),
            modifier = Modifier.constrainAs(icGeo) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            },
            tint = MaterialTheme.colors.primary
        )

        Text(
            text = primaryAddress,
            modifier = Modifier.constrainAs(textPrimary) {
                start.linkTo(icGeo.end, 12.dp)
                top.linkTo(parent.top)
                bottom.linkTo(textSecondary.top)
                end.linkTo(icArrow.start)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = secondaryAddress,
            modifier = Modifier.constrainAs(textSecondary) {
                start.linkTo(icGeo.end, 12.dp)
                top.linkTo(textPrimary.bottom)
                bottom.linkTo(parent.bottom)
                end.linkTo(icArrow.start)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.caption,
            color = if (isSystemInDarkTheme()) Grey50 else Grey50,
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
            tint = MaterialTheme.colors.primary
        )
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GeolocationItemGroupLight() {
    W3WTheme {
        GeolocationItem("Alfred Road", "London", true, {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GeolocationItemGroupDark() {
    W3WTheme {
        GeolocationItem("Alfred Road", "London", true, {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun GeolocationItemSingleLight() {
    W3WTheme {
        GeolocationItem("What3words, 65 Alfred Road", "London, W2 5EU", false, {})
    }
}

@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GeolocationItemSingleDark() {
    W3WTheme {
        GeolocationItem("What3words, 65 Alfred Road", "London, W2 5EU", false, {})
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun GeolocationItemSingleRightToLeft() {
    W3WTheme {
        GeolocationItem("ابو فيوض لادوات الصيد", "المحمودية، سنابادة، مركز المحمودية،، البحيرة 5872461", false, {})
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun GeolocationItemGroupRightToLeft() {
    W3WTheme {
        GeolocationItem("ابو فيوض لادوات الصيد", "المحمودية، سنابادة، مركز المحمودية،، البحيرة 5872461", true, {})
    }
}

