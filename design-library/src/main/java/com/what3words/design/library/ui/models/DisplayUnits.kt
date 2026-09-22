package com.what3words.design.library.ui.models

import android.content.Context
import android.icu.text.DecimalFormat
import android.icu.text.MeasureFormat
import android.icu.text.NumberFormat
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import java.util.Locale
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Enumeration for different types of display units.
 */
enum class DisplayUnits {
    SYSTEM, // Uses the system default units (either metric or imperial, depending on the locale)
    IMPERIAL, // Explicitly uses imperial units (miles, feet, etc.)
    METRIC // Explicitly uses metric units (kilometers, meters, etc.)
}

const val KM_TO_MILES_FACTOR = 1.609
private const val MILES_TO_FT_FACTOR = 5280
private const val KM_TO_METERS_FACTOR = 1000

private const val MAX_FRACTION_DIGITS = 2

private val imperialCountries = hashSetOf("US", "LR", "MM", "BS", "BZ", "KY", "PW", "GB", "UK")

data class DistanceSeparators(val grouping: Char?, val decimal: Char)

private fun renderDistance(
    distanceMeters: Double,
    displayUnits: DisplayUnits,
    separators: DistanceSeparators?,
    locale: Locale
): String {
    if (!distanceMeters.isFinite()) return ""

    val metric = isMetricDisplayUnitEnabled(displayUnits, locale)
    val unit = if (metric) MeasureUnit.KILOMETER else MeasureUnit.MILE
    val km = distanceMeters / KM_TO_METERS_FACTOR
    val converted = if (metric) km else km / KM_TO_MILES_FACTOR

    val (rounded, fractionDigits) = roundForDisplay(converted)

    val numberFormat = NumberFormat.getInstance(locale).apply {
        isGroupingUsed = separators == null || separators.grouping != null
        minimumFractionDigits = 0
        maximumFractionDigits = fractionDigits
        if (separators != null) {
            (this as? DecimalFormat)?.let { df ->
                df.decimalFormatSymbols = df.decimalFormatSymbols.also { symbols ->
                    symbols.decimalSeparator = separators.decimal
                    separators.grouping?.let { symbols.groupingSeparator = it }
                }
            }
        }
    }

    return MeasureFormat.getInstance(locale, MeasureFormat.FormatWidth.SHORT, numberFormat)
        .format(Measure(rounded, unit))
}

/**
 * Formats a distance for display
 *
 * @param distanceMeters The distance in whole metres.
 * @param displayUnits The display units to use (SYSTEM, IMPERIAL, METRIC).
 * @param locale The locale used for the numerals, decimal/grouping separators and unit name.
 *   Defaults to [Locale.getDefault].
 * @return A formatted string such as `0.34 km`, `12.6 km`, `1,234 km` or `0.21 mi`.
 */
fun formatDistance(
    distanceMeters: Int,
    displayUnits: DisplayUnits = DisplayUnits.SYSTEM,
    separators: DistanceSeparators? = null,
    locale: Locale = Locale.getDefault()
): String = renderDistance(distanceMeters.toDouble(), displayUnits, separators, locale)

/**
 * Formats a distance for display
 *
 * @param distanceKm The distance in kilometres, e.g. `W3WDistance.km()`. Non-finite values
 *   produce an empty string.
 * @param displayUnits The display units to use (SYSTEM, IMPERIAL, METRIC).
 * @param locale The locale used for the numerals, decimal/grouping separators and unit name.
 *   Defaults to [Locale.getDefault].
 * @return A formatted string such as `0.34 km`, `12.6 km`, `1,234 km` or `0.21 mi`.
 */
fun formatDistanceKm(
    distanceKm: Double,
    displayUnits: DisplayUnits = DisplayUnits.SYSTEM,
    separators: DistanceSeparators? = null,
    locale: Locale = Locale.getDefault()
): String = renderDistance(distanceKm * KM_TO_METERS_FACTOR, displayUnits, separators, locale)

/**
 * Applies the rounding rule to a value already expressed in the display unit.
 *
 * @return the rounded value and the number of fraction digits it should be rendered with.
 */
internal fun roundForDisplay(valueInDisplayUnit: Double): Pair<Double, Int> {
    val magnitude = abs(valueInDisplayUnit)
    val fractionDigits = when {
        magnitude >= 100.0 -> 0
        magnitude >= 10.0 -> 1
        else -> MAX_FRACTION_DIGITS
    }

    val scale = 10.0.pow(fractionDigits)
    val scaled = valueInDisplayUnit * scale
    val rounded = (if (scaled >= 0) floor(scaled + 0.5) else ceil(scaled - 0.5)) / scale

    return rounded to fractionDigits
}

/**
 * Formats the distance based on the specified display units and local conventions.
 *
 * @param distanceKm The distance in kilometers.
 * @param displayUnits The display units to use (SYSTEM, IMPERIAL, METRIC).
 * @param context Unused; retained for binary compatibility.
 * @return A formatted string representing the distance.
 */
@Deprecated(
    message = "Distances are now expressed in metres. This function takes whole kilometres and " +
        "so cannot represent sub-kilometre distances; use formatDistance instead.",
    replaceWith = ReplaceWith("formatDistance(distanceKm * 1000, displayUnits)")
)
@Suppress("UNUSED_PARAMETER")
fun formatUnits(distanceKm: Int, displayUnits: DisplayUnits, context: Context): String =
    formatDistance(distanceKm * 1000, displayUnits)

// Signature frozen: consumed externally by w3w-android-map-components (MyLocationButton.kt).
fun getAccuracyString(accuracyInMeters: Float, displayUnits: DisplayUnits): String {
    val locale = Locale.getDefault()
    val fmtFr = MeasureFormat.getInstance(locale, MeasureFormat.FormatWidth.SHORT)
    val meters = accuracyInMeters.toDouble()
    return if (isMetricDisplayUnitEnabled(displayUnits, locale)) {
        if (meters < KM_TO_METERS_FACTOR) {
            fmtFr.format(Measure(meters.roundToInt(), MeasureUnit.METER))
        } else {
            fmtFr.format(
                Measure((meters / KM_TO_METERS_FACTOR).roundToInt(), MeasureUnit.KILOMETER)
            )
        }
    } else {
        val accuracyInMiles = meters / KM_TO_METERS_FACTOR / KM_TO_MILES_FACTOR
        if (accuracyInMiles < 1) {
            fmtFr.format(
                Measure((accuracyInMiles * MILES_TO_FT_FACTOR).roundToInt(), MeasureUnit.FOOT)
            )
        } else {
            fmtFr.format(Measure(accuracyInMiles.roundToInt(), MeasureUnit.MILE))
        }
    }
}

/**
 * Checks if the metric display unit is enabled based on the display units setting and [locale].
 *
 * @param displayUnits The display units setting.
 * @param locale The locale consulted when [displayUnits] is [DisplayUnits.SYSTEM].
 * @return `true` if the metric system is enabled, `false` otherwise.
 */
private fun isMetricDisplayUnitEnabled(displayUnits: DisplayUnits, locale: Locale): Boolean {
    return (displayUnits == DisplayUnits.SYSTEM && locale.isMetric()) ||
            displayUnits == DisplayUnits.METRIC
}

/**
 * Extension function for Locale to determine if it uses the metric system.
 *
 * @return `true` if the locale uses the metric system, `false` if it uses the imperial system.
 */
fun Locale.isMetric(): Boolean {
    return !imperialCountries.contains(country.uppercase(this))
}
