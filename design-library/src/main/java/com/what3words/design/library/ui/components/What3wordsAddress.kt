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
     * Creates a [What3wordsAddressDefaults.Colors] instance with customizable color properties for the [What3wordsAddress] composable.
     * This function allows overriding the default colors used in various parts of the [What3wordsAddress] UI component.
     *
     * @param background The color for the background of the [What3wordsAddress].
     * @param backgroundHighlighted The color for the background of the highlighted [What3wordsAddress].
     * @param slashesColor The color of the slashes between words in the [What3wordsAddress].
     * @param wordsTextColor The color of the text for the words in the [What3wordsAddress].
     * @param iconColor The color of any icons displayed within the [What3wordsAddress].
     * @param nearestPlaceTextColor The color of the text for the nearest place description in the [What3wordsAddress].
     * @param distanceTextColor The color of the text showing distance in the [What3wordsAddress].
     * @param dividerColor The color of dividers used within the [What3wordsAddress].
     * @param labelBackground The background color of labels in the [What3wordsAddress].
     * @param labelTextColor The color of the text in labels within the [What3wordsAddress].
     *
     * @return A [What3wordsAddressDefaults.Colors] object containing the specified colors.
     *         This object can then be applied to the [What3wordsAddress] composable for customization.
     *
     * This function provides a convenient way to create a cohesive color theme for the What3wordsAddress component,
     * making it easy to align its appearance with the overall design of the application.
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
     * Creates a [What3wordsAddressDefaults.TextStyles] instance with customizable text style properties for the [What3wordsAddress] composable.
     * This function allows for overriding the default text styles used in different parts of the [What3wordsAddress] UI composable.
     *
     * @param wordsTextStyle The [TextStyle] to be applied to the words of the [What3wordsAddress].
     * @param nearestPlaceTextStyle The [TextStyle] for displaying the nearest place description in the [What3wordsAddress].
     * @param distanceTextStyle The [TextStyle] for displaying the distance information in the [What3wordsAddress].
     * @param labelTextStyle The [TextStyle] for any labels within the [What3wordsAddress].
     *
     * @return A [What3wordsAddressDefaults.TextStyles] object containing the specified text styles.
     *         This object can then be applied to the [What3wordsAddress] composable for customization.
     *
     * This function provides a streamlined way to define and apply consistent text styling across the What3wordsAddress composable,
     * enhancing the visual coherence with the overall design language of the application.
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
 * Displays a What3words address in a formatted manner. The What3words system divides the world into 3m x 3m squares,
 * each with a unique what3words address. This composable function presents these addresses with additional details like
 * nearest place, distance, and custom styling options.
 *
 * @param words The what3words address. Each word is separated by dots or use break lines between words to force the split.
 * @param modifier [Modifier] for styling and layout of the address view. Default is [Modifier].
 * @param nearestPlace Optional. The nearest significant place to the 3-word address. Null if not specified.
 * @param nearestPlacePrefix Optional. The prefix text for the nearest place. Default is a string resource.
 * @param isLand Boolean indicating if the location is on land (true) or water (false). Default is true.
 * @param distance Optional. The distance to the location. Null if not specified.
 * @param displayUnits Units for displaying the distance. Default is [DisplayUnits.SYSTEM].
 * @param isHighlighted If true, highlights the address. Default is false.
 * @param label Optional. A label to display alongside the address. Null if not specified.
 * @param colors Color scheme for various elements of the address view. Default is defined by [What3wordsAddressDefaults.defaultColors].
 * @param textStyles Text style customization for different elements of the address view. Default is defined by [What3wordsAddressDefaults.defaultTextStyles].
 * @param showDivider Boolean to control the visibility of a divider line below the address. Default is true.
 * @param onClick Optional. Lambda function to handle click events. Null if no action is specified.
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
