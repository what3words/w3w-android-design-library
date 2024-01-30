package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.what3words.design.library.ui.models.DisplayUnits
import com.what3words.design.library.ui.models.formatUnits
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.w3wTypography

object What3wordsAddressListItemDefaults {
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
     * Creates a [What3wordsAddressListItemDefaults.Colors] instance with customizable color properties for the [What3wordsAddressListItem] composable.
     * This function allows overriding the default colors used in various parts of the [What3wordsAddressListItem] UI component.
     *
     * @param background The color for the background of the [What3wordsAddressListItem].
     * @param backgroundHighlighted The color for the background of the highlighted [What3wordsAddressListItem].
     * @param slashesColor The color of the slashes between words in the [What3wordsAddressListItem].
     * @param wordsTextColor The color of the text for the words in the [What3wordsAddressListItem].
     * @param iconColor The color of any icons displayed within the [What3wordsAddressListItem].
     * @param nearestPlaceTextColor The color of the text for the nearest place description in the [What3wordsAddressListItem].
     * @param distanceTextColor The color of the text showing distance in the [What3wordsAddressListItem].
     * @param dividerColor The color of dividers used within the [What3wordsAddressListItem].
     * @param labelBackground The background color of labels in the [What3wordsAddressListItem].
     * @param labelTextColor The color of the text in labels within the [What3wordsAddressListItem].
     *
     * @return A [What3wordsAddressListItemDefaults.Colors] object containing the specified colors.
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
     * Creates a [What3wordsAddressListItemDefaults.TextStyles] instance with customizable text style properties for the [What3wordsAddressListItem] composable.
     * This function allows for overriding the default text styles used in different parts of the [What3wordsAddressListItem] UI composable.
     *
     * @param wordsTextStyle The [TextStyle] to be applied to the words of the [What3wordsAddressListItem].
     * @param nearestPlaceTextStyle The [TextStyle] for displaying the nearest place description in the [What3wordsAddressListItem].
     * @param distanceTextStyle The [TextStyle] for displaying the distance information in the [What3wordsAddressListItem].
     * @param labelTextStyle The [TextStyle] for any labels within the [What3wordsAddressListItem].
     *
     * @return A [What3wordsAddressListItemDefaults.TextStyles] object containing the specified text styles.
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
        labelTextStyle: TextStyle = MaterialTheme.typography.labelLarge
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
 * Composable function to display a list item representing a What3words address.
 * This function provides a customizable and responsive way to display What3words addresses
 * with optional details such as nearest place, distance, and custom labels.
 *
 * @param words The what3words address.
 * @param modifier [Modifier] for styling and layout of the address view. Default is [Modifier].
 * @param nearestPlace Optional. The nearest significant place to the 3-word address. Null if not specified.
 * @param nearestPlacePrefix Optional. The prefix text for the nearest place. Default is a string resource.
 * @param isLand Boolean indicating if the location is on land (true) or water (false). Default is true.
 * @param distance Optional. The distance to the location. Null if not specified.
 * @param displayUnits Units for displaying the distance. Default is [DisplayUnits.SYSTEM].
 * @param isHighlighted If true, highlights the address. Default is false.
 * @param label Optional. A label to display alongside the address. Null if not specified.
 * @param colors Color scheme for various elements of the address view. Default is defined by [What3wordsAddressListItemDefaults.defaultColors].
 * @param textStyles Text style customization for different elements of the address view. Default is defined by [What3wordsAddressListItemDefaults.defaultTextStyles].
 * @param showDivider Boolean to control the visibility of a divider line below the address. Default is true.
 * @param onClick Optional. Lambda function to handle click events. Null if no action is specified.
 */
@Composable
fun What3wordsAddressListItem(
    words: String,
    modifier: Modifier = Modifier,
    nearestPlace: String? = null,
    nearestPlacePrefix: String? = stringResource(id = com.what3words.design.library.R.string.near),
    isLand: Boolean = true,
    distance: Int? = null,
    displayUnits: DisplayUnits = DisplayUnits.SYSTEM,
    isHighlighted: Boolean = false,
    label: String? = null,
    colors: What3wordsAddressListItemDefaults.Colors = What3wordsAddressListItemDefaults.defaultColors(),
    textStyles: What3wordsAddressListItemDefaults.TextStyles = What3wordsAddressListItemDefaults.defaultTextStyles(),
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
            ResponsiveText(
                text = stringResource(id = R.string.slashes),
                modifier = Modifier
                    .wrapContentWidth()
                    .constrainAs(textSlashes) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                style = textStyles.wordsTextStyle,
                color = colors.slashesColor,
                targetTextSizeHeight = textSize
            )

            ResponsiveText(
                modifier = Modifier.constrainAs(textWords) {
                    top.linkTo(textSlashes.top)
                    start.linkTo(textSlashes.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                text = words,
                style = textStyles.wordsTextStyle,
                color = colors.wordsTextColor,
                targetTextSizeHeight = textSize,
                resizeFunc = {
                    textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
                },
                textAlign = TextAlign.Start,
                maxLines = 1
            )

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
                textAlign = TextAlign.Start
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
                        .padding(vertical = 4.dp, horizontal = 4.dp),
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

//region Previews with W3WTheme day
@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A1() {
    W3WTheme {
        What3wordsAddressListItem("filled.count.soap")
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR with near", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A2() {
    W3WTheme {
        What3wordsAddressListItem("filled.count.soap", nearestPlace = "Bayswater, London")
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR with distance", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A3() {
    W3WTheme {
        What3wordsAddressListItem("filled.count.soap", distance = 20)
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR with long what3words address", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A4() {
    W3WTheme {
        What3wordsAddressListItem(
            "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London"
        )
    }
}


@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR in land with near and distance", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A5() {
    W3WTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20
        )
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR in sea with near", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A6() {
    W3WTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            isLand = false
        )
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Day/LTR with near, distance and label", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A7() {
    W3WTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20,
            label = "Label name"
        )
    }
}

@Preview(group = "W3WTheme", locale = "ar", name = "W3WTheme/Day/RTL with near and distance", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun A8() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        W3WTheme {
            What3wordsAddressListItem(
                "القطار.مسعف.شخصيات",
                nearestPlace = "لندن, London",
                distance = 20
            )
        }
    }
}
//endregion

//region Previews with W3WTheme night
@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B1() {
    W3WTheme {
        What3wordsAddressListItem("filled.count.soap")
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR with near", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B2() {
    W3WTheme {
        What3wordsAddressListItem("filled.count.soap", nearestPlace = "Bayswater, London")
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR with distance", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B3() {
    W3WTheme {
        What3wordsAddressListItem("filled.count.soap", distance = 20)
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR with long what3words address", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B4() {
    W3WTheme {
        What3wordsAddressListItem(
            "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London"
        )
    }
}


@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR in land with near and distance", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B5() {
    W3WTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20
        )
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR in sea with near", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B6() {
    W3WTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            isLand = false
        )
    }
}

@Preview(group = "W3WTheme", name = "W3WTheme/Night/LTR with near, distance and label", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B7() {
    W3WTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20,
            label = "Label name"
        )
    }
}

@Preview(group = "W3WTheme", locale = "ar", name = "W3WTheme/Night/RTL with near and distance", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun B8() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        W3WTheme {
            What3wordsAddressListItem(
                "القطار.مسعف.شخصيات",
                nearestPlace = "لندن, London",
                distance = 20
            )
        }
    }
}
//endregion

//region Previews with MaterialTheme day
@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C1() {
    MaterialTheme {
        What3wordsAddressListItem("filled.count.soap")
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR with near", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C2() {
    MaterialTheme {
        What3wordsAddressListItem("filled.count.soap", nearestPlace = "Bayswater, London")
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR with distance", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C3() {
    MaterialTheme {
        What3wordsAddressListItem("filled.count.soap", distance = 20)
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR with long what3words address", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C4() {
    MaterialTheme {
        What3wordsAddressListItem(
            "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London"
        )
    }
}


@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR in land with near and distance", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C5() {
    MaterialTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20
        )
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR in sea with near", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C6() {
    MaterialTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            isLand = false
        )
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Day/LTR with near, distance and label", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C7() {
    MaterialTheme {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20,
            label = "Label name"
        )
    }
}

@Preview(group = "MaterialTheme", locale = "ar", name = "MaterialTheme/Day/RTL with near and distance", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun C8() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        MaterialTheme {
            What3wordsAddressListItem(
                "القطار.مسعف.شخصيات",
                nearestPlace = "لندن, London",
                distance = 20
            )
        }
    }
}
//endregion

//region Previews with MaterialTheme night
@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D1() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem("filled.count.soap")
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR with near", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D2() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem("filled.count.soap", nearestPlace = "Bayswater, London")
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR with distance", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D3() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem("filled.count.soap", distance = 20)
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR with long what3words address", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D4() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem(
            "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London"
        )
    }
}


@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR in land with near and distance", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D5() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20
        )
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR in sea with near", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D6() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            isLand = false
        )
    }
}

@Preview(group = "MaterialTheme", name = "MaterialTheme/Night/LTR with near, distance and label", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D7() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        What3wordsAddressListItem(
            "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 20,
            label = "Label name"
        )
    }
}

@Preview(group = "MaterialTheme", locale = "ar", name = "MaterialTheme/Night/RTL with near and distance", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun D8() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        MaterialTheme(colorScheme = darkColorScheme()) {
            What3wordsAddressListItem(
                "القطار.مسعف.شخصيات",
                nearestPlace = "لندن, London",
                distance = 20
            )
        }
    }
}
//endregion