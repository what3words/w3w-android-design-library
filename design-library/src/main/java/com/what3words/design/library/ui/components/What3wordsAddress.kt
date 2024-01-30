package com.what3words.design.library.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.what3words.design.library.R
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.w3wTypography

/**
 * Object containing default configurations for What3wordsAddress composable.
 * It includes default settings for colors and text styles, which can be customized as needed.
 */
object What3wordsAddressDefaults {
    /**
     * Data class to hold color configurations for What3wordsAddress composable.
     *
     * @property slashesColor Color for the slashes in the What3words address.
     * @property wordsTextColor Text color for the words in the What3words address.
     */
    data class Colors(
        val slashesColor: Color,
        val wordsTextColor: Color,
    )

    /**
     * Data class to hold text style configurations for What3wordsAddress composable.
     *
     * @property wordsTextStyle Text style for the words in the What3words address.
     */
    data class TextStyles(
        val wordsTextStyle: TextStyle
    )

    /**
     * Provides default color settings for What3wordsAddress composable.
     *
     * @param slashesColor Default color for slashes, defaults to MaterialTheme's primary color.
     * @param wordsTextColor Default text color for words, defaults to MaterialTheme's onSecondaryContainer color.
     * @return An instance of [Colors] with the specified or default color settings.
     */
    @Composable
    fun defaultColors(
        slashesColor: Color = MaterialTheme.colorScheme.primary,
        wordsTextColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
    ): Colors {
        return Colors(
            slashesColor = slashesColor,
            wordsTextColor = wordsTextColor
        )
    }

    /**
     * Provides default text style settings for What3wordsAddress composable.
     *
     * @param wordsTextStyle Default text style for words, defaults to What3words typography headlineLargeProminent style.
     * @return An instance of [TextStyles] with the specified or default text style settings.
     */
    @Composable
    fun defaultTextStyles(
        wordsTextStyle: TextStyle = MaterialTheme.w3wTypography.headlineLargeProminent,
    ): TextStyles {
        return TextStyles(
            wordsTextStyle = wordsTextStyle
        )
    }
}


/**
 * Composable function to display a What3words address.
 * It offers customizable styles for text and colors, and utilizes responsive text to adjust to container sizes.
 *
 * @param words The What3words address to be displayed.
 * @param modifier Modifier to be applied to the What3words address layout.
 * @param colors Customizable color settings for the component.
 * @param textStyles Customizable text style settings for the component.
 */
@Composable
fun What3wordsAddress(
    words: String,
    modifier: Modifier = Modifier,
    colors: What3wordsAddressDefaults.Colors = What3wordsAddressDefaults.defaultColors(),
    textStyles: What3wordsAddressDefaults.TextStyles = What3wordsAddressDefaults.defaultTextStyles(),
) {
    Row(
        modifier = modifier
    ) {
        val startFontSize = textStyles.wordsTextStyle.fontSize
        var textSize by remember { mutableStateOf(startFontSize) }
        ResponsiveText(
            text = stringResource(id = R.string.slashes),
            modifier = Modifier
                .wrapContentWidth(),
            style = textStyles.wordsTextStyle,
            color = colors.slashesColor,
            targetTextSizeHeight = textSize
        )

        ResponsiveText(
            modifier = Modifier,
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
    }
}

//region Previews with W3WTheme day
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
    uiMode = UI_MODE_NIGHT_NO,
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