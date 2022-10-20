package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.Grey70
import com.what3words.design.library.ui.theme.Red
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.White

@Composable
fun SuggestionItem(
    words: String,
    near: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLand: Boolean = true,
    distance: String? = null,
) {
    ConstraintLayout(modifier = modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .background(MaterialTheme.colors.background)
        .padding(dimensionResource(id = R.dimen.normal_100))
    ) {
        val (textSlashes, textWords, textNear, icSea, textDistance) = createRefs()

        Text(
            text = stringResource(id = R.string.slashes),
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(textSlashes) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            style = MaterialTheme.typography.h2,
            color = Red
        )

        Text(
            text = words,
            modifier = Modifier.constrainAs(textWords) {
                top.linkTo(parent.top)
                start.linkTo(textSlashes.end)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Start
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_sea),
            contentDescription = stringResource(id = R.string.cd_ic_sea),
            modifier = Modifier.constrainAs(icSea) {
                top.linkTo(textNear.top)
                bottom.linkTo(textNear.bottom)
                start.linkTo(textWords.start)
                visibility = if (isLand) Visibility.Gone else Visibility.Visible
            },
            tint = MaterialTheme.colors.primary
        )

        Text(
            text = stringResource(id = R.string.near, near),
            modifier = Modifier.constrainAs(textNear) {
                top.linkTo(textWords.bottom)
                start.linkTo(icSea.end)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.caption,
            color = if (isSystemInDarkTheme()) Grey40 else Grey70,
            textAlign = TextAlign.Start
        )

        if (distance != null) {
            Text(
                text = distance,
                modifier = Modifier.constrainAs(textDistance) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                style = MaterialTheme.typography.subtitle1,
                color = if (isSystemInDarkTheme()) White else Grey70,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightLandPreview() {
    W3WTheme {
        SuggestionItem("index.home.raft", "Bayswater, London", {})
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightDistanceLandPreview() {
    W3WTheme {
        SuggestionItem("index.home.raft", "Bayswater, London", {}, distance = "20km")
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun SuggestionItemLightRightToLeftPreview() {
    W3WTheme {
        SuggestionItem("القطار.مسعف.شخصيات", "لندن, London", {}, distance = "20km")
    }
}

@Preview(locale = "en", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightSeaPreview() {
    W3WTheme {
        SuggestionItem("index.home.raft", "Bayswater, London", {}, isLand = false)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightLandPreview() {
    W3WTheme {
        SuggestionItem("index.home.raft", "Bayswater, London", {})
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightDistanceLandPreview() {
    W3WTheme {
        SuggestionItem("index.home.raft", "Bayswater, London", {}, distance = "20km")
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightSeaPreview() {
    W3WTheme {
        SuggestionItem("index.home.raft", "Bayswater, London", {}, isLand = false)
    }
}