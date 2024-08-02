package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.w3wColorScheme
import com.what3words.design.library.ui.theme.w3wTypography

/**
 * This object contains default configurations for the What3wordsAddress composable function.
 * It provides default color and text style configurations that can be used when displaying a What3words address.
 */
object What3wordsAddressDefaults {

    /**
     * Data class that holds color configurations for the What3wordsAddress composable function.
     *
     * @property slashesColor The color to be used for slashes.
     * @property wordsTextColor The color to be used for words text.
     */
    data class Colors(
        val slashesColor: Color,
        val wordsTextColor: Color,
    )

    /**
     * Data class that holds text style configurations for the What3wordsAddress composable function.
     *
     * @property wordsTextStyle The text style to be used for words text.
     */
    data class TextStyles(
        val wordsTextStyle: TextStyle,
    )

    /**
     * Composable function that provides default color configurations for the What3wordsAddress composable function.
     *
     * @param slashesColor The color to be used for slashes. Default is set by [MaterialTheme.w3wColorScheme.brand].
     * @param wordsTextColor The color to be used for words text. Default is set by [MaterialTheme.colorScheme.onSecondaryContainer].
     * @return A Colors object with the provided color configurations.
     */
    @Composable
    fun defaultColors(
        slashesColor: Color = MaterialTheme.w3wColorScheme.brand,
        wordsTextColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
    ): Colors {
        return Colors(
            slashesColor = slashesColor,
            wordsTextColor = wordsTextColor
        )
    }

    /**
     * Composable function that provides default text style configurations for the What3wordsAddress composable function.
     *
     * @param wordsTextStyle The text style to be used for words text. Default is set by [MaterialTheme.w3wTypography.headlineLargeProminent].
     * @return A TextStyles object with the provided text style configurations.
     */
    @Composable
    fun defaultTextStyles(
        wordsTextStyle: TextStyle = MaterialTheme.w3wTypography.headlineLargeSemibold
    ): TextStyles {
        return TextStyles(
            wordsTextStyle = wordsTextStyle
        )
    }
}


/**
 * A composable function that displays a What3words address with a possible secondary content.
 *
 * @param words The string of words to be displayed.
 * @param modifier The Modifier to be applied to the layout.
 * @param colors The Colors object for color configurations. Default is set by [What3wordsAddressDefaults.defaultColors].
 * @param textStyles The TextStyles object for text style configurations. Default is set by [What3wordsAddressDefaults.defaultTextStyles].
 * @param secondaryContent A composable lambda function for secondary content.
 * @param slashesMargin A lambda function for setting the margin of slashes.
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun What3wordsAddress(
    words: String,
    modifier: Modifier = Modifier,
    colors: What3wordsAddressDefaults.Colors = What3wordsAddressDefaults.defaultColors(),
    textStyles: What3wordsAddressDefaults.TextStyles = What3wordsAddressDefaults.defaultTextStyles(),
    secondaryContent: @Composable () -> Unit = {},
    slashesMargin: ((Dp) -> Unit)? = null
) {
    Column(
        modifier = modifier,
    ) {
        var margin by remember { mutableStateOf(0.dp) }
        val textMeasurer = rememberTextMeasurer()
        val density = LocalDensity.current
        val slashes = stringResource(id = R.string.slashes)
        val buildString = buildAnnotatedString {
            withStyle(ParagraphStyle()) {
                withStyle(
                    style = SpanStyle(color = colors.slashesColor)
                ) {
                    append(slashes)
                }
                withStyle(
                    style = SpanStyle(color = colors.wordsTextColor)
                ) {
                    append(words)
                }
            }
        }
        AutoSizeText(
            text = buildString,
            maxLines = 1,
            //to remove when we update to the latest jetpack compose version
            style = textStyles.wordsTextStyle.copy(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                )
            ),
            maxTextSize = textStyles.wordsTextStyle.fontSize,
            onTextLayout = {
                val widthInPixels = textMeasurer.measure(slashes, it.layoutInput.style).size.width
                val marginDp = with(density) { widthInPixels.toDp() }
                margin = marginDp
                if (slashesMargin != null) {
                    slashesMargin(marginDp)
                }
            }
        )
        Row {
            Spacer(modifier = Modifier.width(margin))
            secondaryContent()
        }
    }
}

@Preview(
    group = "W3WTheme",
    name = "W3WTheme/Day/LTR",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun A1() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "filled.count.soap"
            )
        }
    }
}

@Preview(
    group = "W3WTheme",
    locale = "ar",
    name = "W3WTheme/Day/RTL",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun A2() {
    W3WTheme {
        Surface {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                What3wordsAddress(
                    "لبن.درجات.عنق"
                )
            }
        }
    }
}

@Preview(
    group = "W3WTheme",
    name = "W3WTheme/Day/LTR/Long Text",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun A3() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "congratulations.congratulations.congratulations",
            )
        }
    }
}

@Preview(
    group = "W3WTheme",
    name = "W3WTheme/Day/LTR/SecondaryContent",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun A4() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "filled.count.soap",
                secondaryContent = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Map, contentDescription = "Map")
                        Text(
                            text = "little description",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            )
        }
    }
}

@Preview(
    group = "W3WTheme",
    locale = "ar",
    name = "W3WTheme/Day/RTL/SecondaryContent",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun A5() {
    W3WTheme {
        Surface {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                What3wordsAddress(
                    "لبن.درجات.عنق",
                    secondaryContent = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Map, contentDescription = "Map")
                            Text(
                                text = "وصف قصير",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                )
            }
        }
    }
}

//endregion

//region Previews with W3WTheme night
@Preview(
    group = "W3WTheme",
    name = "W3WTheme/Night/LTR",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun B1() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "filled.count.soap"
            )
        }
    }
}

@Preview(
    group = "W3WTheme",
    locale = "ar",
    name = "W3WTheme/Night/RTL",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun B2() {
    W3WTheme {
        Surface {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                What3wordsAddress(
                    "لبن.درجات.عنق"
                )
            }
        }
    }
}
@Preview(
    group = "W3WTheme",
    name = "W3WTheme/Night/LTR/LongText",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun B3() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "congratulations.congratulations.congratulations",
            )
        }
    }
}

@Preview(
    group = "W3WTheme",
    name = "W3WTheme/Night/LTR/SecondaryContent",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun B4() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "filled.count.soap",
                secondaryContent = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Map, contentDescription = "Map")
                        Text(
                            text = "little description",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            )
        }
    }
}

@Preview(
    group = "W3WTheme",
    locale = "ar",
    name = "W3WTheme/Night/RTL/SecondaryContent",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun B5() {
    W3WTheme {
        Surface {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                What3wordsAddress(
                    "لبن.درجات.عنق",
                    secondaryContent = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Map, contentDescription = "Map")
                            Text(
                                text = "وصف قصير",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                )
            }
        }
    }
}
//endregion

//region Previews with MaterialTheme day
@Preview(
    group = "MaterialTheme",
    name = "MaterialTheme/Day/LTR",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun C1() {
    W3WTheme {
        Surface {
            What3wordsAddress(
                "filled.count.soap"
            )
        }
    }
}

@Preview(
    group = "MaterialTheme",
    locale = "ar",
    name = "MaterialTheme/Day/RTL",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun C2() {
    W3WTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Surface {
                What3wordsAddress(
                    "لبن.درجات.عنق"
                )
            }
        }
    }
}
//endregion

//region Previews with MaterialTheme night
@Preview(
    group = "MaterialTheme",
    name = "MaterialTheme/Night/LTR",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun D1() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        Surface {
            What3wordsAddress(
                "filled.count.soap"
            )
        }
    }
}

@Preview(
    group = "MaterialTheme",
    locale = "ar",
    name = "MaterialTheme/Night/RTL",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun D2() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        Surface {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                What3wordsAddress(
                    "لبن.درجات.عنق"
                )
            }
        }
    }
}
//endregion