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

/** Exact SI definitions, matching the `UnitLength` factors iOS converts with. */
private const val METERS_PER_KILOMETER = 1000.0
private const val METERS_PER_MILE = 1609.344
private const val METERS_PER_FOOT = 0.3048

/** Maximum number of decimals ever shown; iOS clamps to the same two. */
private const val MAX_FRACTION_DIGITS = 2

private val imperialCountries = hashSetOf("US", "LR", "MM", "BS", "BZ", "KY", "PW", "GB", "UK")

/** [grouping] of `null` renders no thousands separator at all: `12000 km`. */
data class DistanceSeparators(val grouping: Char?, val decimal: Char)

/**
 * Formats a distance for display, mirroring the iOS implementation
 * (`W3WDistance.asString(format:system:)` in `w3w-swift-core`).
 *
 * The distance is first converted into the preferred display unit (kilometres or miles) and then
 * rendered with a magnitude-dependent number of decimals:
 *
 * | converted value | decimals |
 * |-----------------|----------|
 * | `< 10`          | 2        |
 * | `< 100`         | 1        |
 * | `>= 100`        | 0        |
 *
 * That table is iOS's rule restated: iOS rounds to 3 significant digits and then clamps to 2
 * decimals, which for every value at or above 1 yields exactly these decimal counts, and below 1
 * yields 2. Rounding is half-away-from-zero and trailing zeros are stripped, as on iOS. There is
 * deliberately no lower threshold: short distances render their real value (e.g. `0.34 km`)
 * rather than `<1 km`.
 *
 * Two presentational details deliberately diverge from iOS, which concatenates a bare `"km"`/
 * `"mi"` onto Western digits: the unit is separated by [locale]'s pattern (`0.34 km`, not
 * `0.34km`) and both the unit name and the numerals are localised. Keeping ICU here is what makes
 * RTL and per-app languages render correctly on Android; the numeric value itself is identical.
 *
 * @param distanceMeters The distance in metres, e.g. `W3WDistance.m().roundToInt()`.
 * @param displayUnits The display units to use (SYSTEM, IMPERIAL, METRIC).
 * @param locale The locale used for the numerals, decimal/grouping separators and unit name.
 *   Defaults to [Locale.getDefault]; Compose callers should pass the configuration locale so that
 *   per-app languages are honoured.
 * @return A formatted string such as `0.34 km`, `12.6 km`, `1,234 km` or `0.21 mi`.
 */
fun formatDistance(
    distanceMeters: Int,
    displayUnits: DisplayUnits = DisplayUnits.SYSTEM,
    separators: DistanceSeparators? = null,
    locale: Locale = Locale.getDefault()
): String {
    val metric = isMetricDisplayUnitEnabled(displayUnits, locale)
    val unit = if (metric) MeasureUnit.KILOMETER else MeasureUnit.MILE
    val converted =
        if (metric) distanceMeters / METERS_PER_KILOMETER else distanceMeters / METERS_PER_MILE

    val (rounded, fractionDigits) = roundForDisplay(converted)

    // Not thread-safe and deliberately not cached: a custom NumberFormat bypasses ICU's
    // MeasureFormat cache anyway, so callers should memoise the result, not the formatter.
    val numberFormat = NumberFormat.getInstance(locale).apply {
        isGroupingUsed = separators == null || separators.grouping != null
        // Order matters: each setter clamps the other. `minimumFractionDigits = 0` is what strips
        // trailing zeros, so 0.5 renders as "0.5" and 1.0 as "1".
        minimumFractionDigits = 0
        maximumFractionDigits = fractionDigits
        // Note: NumberFormat.setRoundingMode throws UnsupportedOperationException for
        // non-DecimalFormat instances, and `rounded` is already at the target scale, so ICU's
        // rounding never engages and the output is independent of the device's ICU version.
        if (separators != null) {
            // Only DecimalFormat exposes the symbols. NumberFormat.getInstance returns a
            // RuleBasedNumberFormat for locales with an algorithmic numbering system
            // (he-u-nu-hebr, zh-u-nu-hanidec, ...), where separators do not apply at all, so
            // those keep the locale's own rendering rather than failing.
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
 * Applies the iOS rounding rule to a value already expressed in the display unit.
 *
 * Kept free of any `android.*` dependency so the numeric rule is unit-testable on a plain JVM.
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

    // Swift's `Double.rounded()` is half-away-from-zero, applied to the scaled value. Replicating
    // that arithmetic — rather than going via BigDecimal — is what reproduces iOS exactly at
    // decimal ties such as 0.145 km, where iOS's own `(n * 100).rounded() / 100` lands.
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
        if (meters < METERS_PER_KILOMETER) {
            fmtFr.format(Measure(meters.roundToInt(), MeasureUnit.METER))
        } else {
            fmtFr.format(
                Measure((meters / METERS_PER_KILOMETER).roundToInt(), MeasureUnit.KILOMETER)
            )
        }
    } else {
        val accuracyInMiles = meters / METERS_PER_MILE
        if (accuracyInMiles < 1) {
            fmtFr.format(Measure((meters / METERS_PER_FOOT).roundToInt(), MeasureUnit.FOOT))
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
 * Note this reflects the units the country uses for road distances rather than whether it is
 * formally metric, so the UK resolves to imperial.
 *
 * @return `true` if the locale uses the metric system, `false` if it uses the imperial system.
 */
fun Locale.isMetric(): Boolean {
    return !imperialCountries.contains(country.uppercase(this))
}
