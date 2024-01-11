package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.what3words.design.library.ui.models.DisplayUnits
import com.what3words.design.library.ui.models.formatUnits
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.w3wTypography

object What3wordsAddressDefaults {
    data class Colors(
        val background: Color,
        val backgroundHighlighted: Color,
        val slashesColor: Color,
        val wordsTextColor: Color,
        val nearestPlaceTextColor: Color,
        val distanceTextColor: Color,
        val dividerColor: Color,
        val labelBackground: Color,
        val labelTextColor: Color,
        val iconColor: Color
    )

    data class TextStyles(
        val wordsTextStyle: TextStyle,
        val nearestPlaceTextStyle: TextStyle,
        val distanceTextStyle: TextStyle,
        val labelTextStyle: TextStyle
    )

    /**
     * Creates [What3wordsAddressDefaults.Colors] to be applied to [What3wordsAddress],
     * allowing to override any [Color] on [What3wordsAddress] composable for customization.
     *
     * @param background set the background [Color] of the [What3wordsAddress].
     * @param backgroundHighlighted set the background [Color] of the highlighted [What3wordsAddress].
     * @param wordsTextColor set text [Color] of the [What3wordsAddress] words.
     * @param nearestPlaceTextColor set text [Color] of the [What3wordsAddress] nearestPlace.
     * @param distanceTextColor set text [Color] of the [What3wordsAddress] distance.
     * @param dividerColor the color of the [Divider].
     *
     * @return [What3wordsAddressDefaults.Colors] that will be applied to the [What3wordsAddress] composable.
     */
    @Composable
    fun defaultColors(
        background: Color = MaterialTheme.colorScheme.surfaceContainerLowest,
        backgroundHighlighted: Color = MaterialTheme.colorScheme.surfaceContainerLowest,
        slashesColor: Color = MaterialTheme.colorScheme.primary,
        wordsTextColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        iconColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        nearestPlaceTextColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        distanceTextColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        dividerColor: Color = MaterialTheme.colorScheme.outlineVariant,
        labelBackground: Color = MaterialTheme.colorScheme.secondaryContainer,
        labelTextColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
    ): Colors {
        return Colors(
            background = background,
            backgroundHighlighted = backgroundHighlighted,
            slashesColor = slashesColor,
            wordsTextColor = wordsTextColor,
            nearestPlaceTextColor = nearestPlaceTextColor,
            distanceTextColor = distanceTextColor,
            dividerColor = dividerColor,
            labelBackground = labelBackground,
            labelTextColor = labelTextColor,
            iconColor = iconColor
        )
    }

    /**
     * Creates [What3wordsAddressDefaults.TextStyles] to be applied to [What3wordsAddress],
     * allowing to override any [TextStyle] on [What3wordsAddress] composable for customization.
     *
     * @param wordsTextStyle set [TextStyle] of the [What3wordsAddress] words.
     * @param nearestPlaceTextStyle set [TextStyle] of the [What3wordsAddress] nearestPlace.
     * @param distanceTextStyle set [TextStyle] of the [What3wordsAddress] distance.
     *
     * @return [What3wordsAddressDefaults.TextStyles] that will be applied to the [What3wordsAddress] composable.
     */
    @Composable
    fun defaultTextStyles(
        wordsTextStyle: TextStyle = MaterialTheme.w3wTypography.titleMediumProminent,
        nearestPlaceTextStyle: TextStyle = MaterialTheme.typography.bodySmall,
        distanceTextStyle: TextStyle = MaterialTheme.typography.bodySmall,
        labelTextStyle: TextStyle = MaterialTheme.typography.bodySmall
    ): TextStyles {
        return TextStyles(
            wordsTextStyle = wordsTextStyle,
            nearestPlaceTextStyle = nearestPlaceTextStyle,
            distanceTextStyle = distanceTextStyle,
            labelTextStyle = labelTextStyle
        )
    }
}

/**
 * [What3wordsAddress] a list item that contains a what3words address information.
 *
 * @param words the what3words address.
 * @param modifier the modifier to be applied to the layout.
 * @param nearestPlace the nearest place to this what3words address.
 * @param isLand if this what3words address is in the land (true) or sea (false).
 * @param distance the distance to this what3words address if current location is known.
 * @param isHighlighted sets this what3words address as highlighted, i.e: when matches exactly the searched text.
 * @param colors set the [What3wordsAddressDefaults.Colors] of [What3wordsAddress].
 * @param textStyles set the [What3wordsAddressDefaults.TextStyles] of [What3wordsAddress].
 * @param showDivider if using on a list and you want to show a [Divider].
 * @param onClick the callback when [What3wordsAddress] is clicked.
 */
@Composable
fun What3wordsAddress(
    words: String,
    modifier: Modifier = Modifier,
    nearestPlace: String? = null,
    nearestPlacePrefix: String? = stringResource(id = com.what3words.design.library.R.string.near),
    isLand: Boolean = true,
    distance: Int? = null,
    displayUnits: DisplayUnits = DisplayUnits.SYSTEM,
    isHighlighted: Boolean = false,
    label: String? = null,
    colors: What3wordsAddressDefaults.Colors = What3wordsAddressDefaults.defaultColors(),
    textStyles: What3wordsAddressDefaults.TextStyles = What3wordsAddressDefaults.defaultTextStyles(),
    showDivider: Boolean = true,
    onClick: (() -> Unit)? = null
) {
    val localContext = LocalContext.current
    Column(
        modifier = modifier
            .clickable(
                onClick = {
                    onClick?.invoke()
                }
            )
            .background(if (isHighlighted) colors.backgroundHighlighted else colors.background)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val (textSlashes, textWords, textNear, icSea, textDistance, textLabel) = createRefs()

            val startFontSize = textStyles.wordsTextStyle.fontSize
            var textSize by remember { mutableStateOf(startFontSize) }
            Text(
                text = stringResource(id = R.string.slashes),
                modifier = Modifier
                    .wrapContentWidth()
                    .constrainAs(textSlashes) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                style = textStyles.wordsTextStyle,
                color = colors.slashesColor
            )

            Column(modifier = Modifier.constrainAs(textWords) {
                top.linkTo(textSlashes.top)
                start.linkTo(textSlashes.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }) {
                if (words.contains("\n")) {
                    Text(
                        text = words,
                        style = textStyles.wordsTextStyle,
                        color = colors.wordsTextColor,
                        textAlign = TextAlign.Start,
                        maxLines = 3
                    )
                } else {
                    ResponsiveText(
                        text = words,
                        textStyle = textStyles.wordsTextStyle,
                        color = colors.wordsTextColor,
                        targetTextSizeHeight = textSize,
                        resizeFunc = {
                            textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
                        },
                        textAlign = TextAlign.Start,
                        maxLines = 1
                    )
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_sea),
                contentDescription = null,
                modifier = Modifier.constrainAs(icSea) {
                    top.linkTo(textSlashes.bottom, 4.dp)
                    start.linkTo(textWords.start)
                    visibility = if (isLand) Visibility.Gone else Visibility.Visible
                },
                tint = colors.iconColor
            )

            Text(
                text = "${nearestPlacePrefix ?: ""} ${nearestPlace ?: ""}",
                modifier = Modifier.constrainAs(textNear) {
                    top.linkTo(textSlashes.bottom, 4.dp)
                    start.linkTo(icSea.end)
                    end.linkTo(textDistance.start, 6.dp)
                    width = Dimension.fillToConstraints
                    visibility =
                        if (nearestPlace.isNullOrEmpty()) Visibility.Gone else Visibility.Visible
                },
                overflow = TextOverflow.Ellipsis,
                style = textStyles.nearestPlaceTextStyle,
                color = colors.nearestPlaceTextColor,
                textAlign = TextAlign.Start,
                maxLines = 1
            )

            if (distance != null) {
                Text(
                    text = formatUnits(distance, displayUnits, localContext),
                    modifier = Modifier.constrainAs(textDistance) {
                        top.linkTo(textSlashes.bottom, 4.dp)
                        end.linkTo(parent.end)
                    },
                    style = textStyles.distanceTextStyle,
                    color = colors.distanceTextColor,
                    textAlign = TextAlign.Start
                )
            }

            if (label != null) {
                Text(
                    text = label,
                    modifier = Modifier
                        .constrainAs(textLabel) {
                            top.linkTo(textNear.bottom, 4.dp)
                            start.linkTo(icSea.start)
                        }
                        .background(colors.labelBackground)
                        .padding(vertical = 8.dp, horizontal = 4.dp),
                    style = textStyles.labelTextStyle,
                    color = colors.labelTextColor,
                    textAlign = TextAlign.Center
                )
            }
        }
        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                color = colors.dividerColor,
                thickness = 1.dp
            )
        }
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDaySimplePreview() {
    W3WTheme {
        What3wordsAddress("index.home.raft")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDayLineBreakPreview() {
    W3WTheme {
        What3wordsAddress("index.\nhome.\nraft")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDayLandPreview() {
    W3WTheme {
        What3wordsAddress("index.home.raft", nearestPlace = "Bayswater, London")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDayOnlyDistancePreview() {
    W3WTheme {
        What3wordsAddress("index.home.raft", distance = 20)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDayLandBigAddressPreview() {
    W3WTheme {
        What3wordsAddress(
            "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London"
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDayDistanceLandPreview() {
    W3WTheme {
        What3wordsAddress(
            "index.home.raft",
            nearestPlace = "Bayswater, London",
            distance = 20
        )
    }
}

@Preview(locale = "ar", showBackground = true)
@Composable
fun SuggestionItemDayRightToLeftPreview() {
    W3WTheme {
        What3wordsAddress("القطار.مسعف.شخصيات", nearestPlace = "لندن, London", distance = 20)
    }
}

@Preview(locale = "en", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDaySeaPreview() {
    W3WTheme {
        What3wordsAddress(
            "index.home.raft",
            nearestPlace = "Bayswater, London",
            isLand = false
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun SuggestionItemDayLabelPreview() {
    W3WTheme {
        What3wordsAddress(
            "index.home.raft",
            nearestPlace = "Bayswater, London",
            distance = 20,
            label = "Label name"
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightSimplePreview() {
    W3WTheme {
        What3wordsAddress("index.home.raft")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightOnlyDistancePreview() {
    W3WTheme {
        What3wordsAddress("index.home.raft", distance = 20)
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightLandPreview() {
    W3WTheme {
        What3wordsAddress("index.home.raft", nearestPlace = "Bayswater, London")
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightDistanceLandPreview() {
    W3WTheme {
        What3wordsAddress(
            "index.home.raft",
            nearestPlace = "Bayswater, London",
            distance = 20,
            displayUnits = DisplayUnits.IMPERIAL
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightSeaPreview() {
    W3WTheme {
        What3wordsAddress(
            "index.home.raft",
            nearestPlace = "Bayswater, London",
            isLand = false
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SuggestionItemNightLabelPreview() {
    W3WTheme {
        What3wordsAddress(
            "index.home.raft",
            nearestPlace = "Bayswater, London",
            distance = 20,
            label = "Label name"
        )
    }
}
