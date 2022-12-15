package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Divider
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

/**
 * [SuggestionWhat3words] a list item that contains a what3words address information.
 *
 * @param words the what3words address.
 * @param modifier the modifier to be applied to the layout.
 * @param nearestPlace the nearest place to this what3words address.
 * @param isLand if this what3words address is in the land (true) or sea (false).
 * @param distance the distance to this what3words address if current location is known.
 * @param isHighlighted sets this what3words address as highlighted, i.e: when matches exactly the searched text.
 * @param background set the background [Color] of the non-highlighted [SuggestionWhat3words].
 * @param backgroundHighlighted set the background [Color] of the highlighted [SuggestionWhat3words].
 * @param wordsTextStyle set [TextStyle] of the [words].
 * @param wordsTextColor set text [Color] of the [words].
 * @param nearestPlaceTextStyle set [TextStyle] of the [nearestPlace].
 * @param nearestPlaceTextColor set text [Color] of the [nearestPlace].
 * @param showDivider if using on a list and you want to show a [Divider].
 * @param dividerColor the color of the [Divider].
 * @param onClick the callback when [SuggestionWhat3words] is clicked.
 */
@Composable
fun SuggestionWhat3words(
    words: String,
    modifier: Modifier = Modifier,
    nearestPlace: String? = null,
    isLand: Boolean = true,
    distance: String? = null,
    isHighlighted: Boolean = false,
    background: Color = W3WTheme.colors.background,
    backgroundHighlighted: Color = W3WTheme.colors.backgroundHighlighted,
    wordsTextStyle: TextStyle = W3WTheme.typography.headline,
    wordsTextColor: Color = W3WTheme.colors.primary,
    nearestPlaceTextStyle: TextStyle = W3WTheme.typography.footnote,
    nearestPlaceTextColor: Color = W3WTheme.colors.textPrimary,
    distanceTextStyle: TextStyle = W3WTheme.typography.caption1,
    distanceTextColor: Color = W3WTheme.colors.textPrimary,
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
            .background(if (isHighlighted) backgroundHighlighted else background)
            .padding(W3WTheme.dimensions.paddingMedium)
        ) {
            val (textSlashes, textWords, textNear, icSea, textDistance) = createRefs()

            val startFontSize = wordsTextStyle.fontSize
            var textSize by remember { mutableStateOf(startFontSize) }

            ResponsiveText(
                text = stringResource(id = R.string.slashes),
                modifier = Modifier
                    .wrapContentWidth()
                    .constrainAs(textSlashes) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                textStyle = wordsTextStyle,
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
                textStyle = wordsTextStyle,
                color = wordsTextColor,
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
                text = stringResource(id = R.string.near, nearestPlace.orEmpty()),
                modifier = Modifier.constrainAs(textNear) {
                    top.linkTo(textSlashes.bottom, 4.dp)
                    start.linkTo(icSea.end)
                    end.linkTo(textDistance.start, 6.dp)
                    width = Dimension.fillToConstraints
                    visibility =
                        if (nearestPlace.isNullOrEmpty()) Visibility.Invisible else Visibility.Visible
                },
                overflow = TextOverflow.Ellipsis,
                style = nearestPlaceTextStyle,
                color = nearestPlaceTextColor,
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
        if (showDivider) {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = dividerColor,
                thickness = W3WTheme.dimensions.divider
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", nearestPlace = "Bayswater, London")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightLandBigAddressPreview() {
    W3WTheme {
        SuggestionWhat3words(
            "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London"
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightDistanceLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", nearestPlace = "Bayswater, London", distance = "20km")
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun SuggestionItemLightRightToLeftPreview() {
    W3WTheme {
        SuggestionWhat3words("القطار.مسعف.شخصيات", nearestPlace = "لندن, London", distance = "20km")
    }
}

@Preview(locale = "en", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemLightSeaPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", nearestPlace = "Bayswater, London", isLand = false)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", nearestPlace = "Bayswater, London")
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightDistanceLandPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", nearestPlace = "Bayswater, London", distance = "20km")
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightSeaPreview() {
    W3WTheme {
        SuggestionWhat3words("index.home.raft", nearestPlace = "Bayswater, London", isLand = false)
    }
}