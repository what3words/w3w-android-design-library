package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun SuggestionWhat3words(
    words: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    near: String? = null,
    isLand: Boolean = true,
    distance: String? = null,
    isHighlighted: Boolean = false,
    background: Color = W3WTheme.colors.background,
    backgroundHighlighted: Color = W3WTheme.colors.backgroundHighlighted,
    addressTextStyle: TextStyle = W3WTheme.typography.headline,
    addressTextColor: Color = W3WTheme.colors.primary,
    nearTextStyle: TextStyle = W3WTheme.typography.footnote,
    nearTextColor: Color = W3WTheme.colors.textFootnote,
    distanceTextStyle: TextStyle = W3WTheme.typography.caption1,
    distanceTextColor: Color = W3WTheme.colors.textSecondary,
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
        .background(if (isHighlighted) backgroundHighlighted else background)
        .padding(W3WTheme.dimensions.paddingMedium)
    ) {
        val (textSlashes, textWords, textNear, icSea, textDistance) = createRefs()

        val startFontSize = addressTextStyle.fontSize
        var textSize by remember { mutableStateOf(startFontSize) }

        ResponsiveText(
            text = stringResource(id = R.string.slashes),
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(textSlashes) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            textStyle = addressTextStyle,
            targetTextSizeHeight = textSize,
            color = W3WTheme.colors.accent
        )

        ResponsiveText(
            text = words,
            modifier = Modifier.constrainAs(textWords) {
                top.linkTo(textSlashes.top)
                bottom.linkTo(textSlashes.bottom)
                start.linkTo(textSlashes.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            textStyle = addressTextStyle,
            color = addressTextColor,
            targetTextSizeHeight = textSize,
            resizeFunc = {
                textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
            },
            textAlign = TextAlign.Start,
            maxLines = 1
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
            tint = W3WTheme.colors.textPrimary
        )

        Text(
            text = stringResource(id = R.string.near, near.orEmpty()),
            modifier = Modifier.constrainAs(textNear) {
                top.linkTo(textSlashes.bottom, 4.dp)
                start.linkTo(icSea.end)
                end.linkTo(textDistance.start, 6.dp)
                width = Dimension.fillToConstraints
                visibility = if (near.isNullOrEmpty()) Visibility.Invisible else Visibility.Visible
            },
            overflow = TextOverflow.Ellipsis,
            style = nearTextStyle,
            color = nearTextColor,
            textAlign = TextAlign.Start,
            maxLines = 1
        )

        if (distance != null) {
            Text(
                text = distance,
                modifier = Modifier.constrainAs(textDistance) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                style = distanceTextStyle,
                color = distanceTextColor,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", near = "Bayswater, London")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightLandBigAddressPreview() {
    W3WTheme {
        SuggestionWhat3words(
            "congratulations.congratulations.congratulations",
            near = "Bayswater, London"
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightDistanceLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", near = "Bayswater, London", distance = "20km")
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun SuggestionItemLightRightToLeftPreview() {
    W3WTheme {
        SuggestionWhat3words("القطار.مسعف.شخصيات", near = "لندن, London", distance = "20km")
    }
}

@Preview(locale = "en", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightSeaPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", near = "Bayswater, London", isLand = false)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", near = "Bayswater, London")
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightDistanceLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", near = "Bayswater, London", distance = "20km")
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightSeaPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", near = "Bayswater, London", isLand = false)
    }
}