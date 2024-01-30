package com.what3words.design.library.ui.models

import android.content.Context
import android.icu.text.MeasureFormat
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import com.what3words.design.library.R
import java.util.Locale
import kotlin.math.roundToInt

/**
 * Enumeration for different types of display units.
 */
enum class DisplayUnits {
    SYSTEM, // Uses the system default units (either metric or imperial, depending on the locale)
    IMPERIAL, // Explicitly uses imperial units (miles, feet, etc.)
    METRIC // Explicitly uses metric units (kilometers, meters, etc.)
}

private const val KM_TO_MILES_FACTOR = 1.609
private val imperialCountries = hashSetOf("US", "LR", "MM", "BS", "BZ", "KY", "PW", "GB", "UK")

/**
 * Formats the distance based on the specified display units and local conventions.
 *
 * @param distanceKm The distance in kilometers.
 * @param displayUnits The display units to use (SYSTEM, IMPERIAL, METRIC).
 * @param context The Android context.
 * @return A formatted string representing the distance.
 */
internal fun formatUnits(distanceKm: Int, displayUnits: DisplayUnits, context: Context): String {
    if (isDistanceBelowThresholdInPreferredUnits(distanceKm, displayUnits)) {
        if (isMetricDisplayUnitEnabled(displayUnits)) {
            val fmtFr =
                MeasureFormat.getInstance(Locale.getDefault(), MeasureFormat.FormatWidth.SHORT)
            val measureF = Measure(1, MeasureUnit.KILOMETER)
            return context.getString(R.string.distance_metric_low, fmtFr.format(measureF))
        } else {
            val fmtFr =
                MeasureFormat.getInstance(Locale.getDefault(), MeasureFormat.FormatWidth.SHORT)
            val measureF = Measure(1, MeasureUnit.MILE)
            return context.getString(R.string.distance_metric_low, fmtFr.format(measureF))
        }
    } else {
        val fmtFr =
            MeasureFormat.getInstance(Locale.getDefault(), MeasureFormat.FormatWidth.SHORT)
        return if (isMetricDisplayUnitEnabled(displayUnits)) {
            val measureF = Measure(distanceKm, MeasureUnit.KILOMETER)
            fmtFr.format(measureF)
        } else {
            val measureF = Measure((distanceKm / KM_TO_MILES_FACTOR).roundToInt(), MeasureUnit.MILE)
            fmtFr.format(measureF)
        }
    }
}

/**
 * Determines if the distance is below a certain threshold when converted to preferred units.
 *
 * @param distanceKm The distance in kilometers.
 * @param displayUnits The display units to use.
 * @return `true` if the distance is below the threshold in the preferred units, `false` otherwise.
 */
private fun isDistanceBelowThresholdInPreferredUnits(
    distanceKm: Int,
    displayUnits: DisplayUnits
): Boolean {
    return distanceKm == 0 ||
            (
                    displayUnits == DisplayUnits.SYSTEM && !Locale.getDefault()
                        .isMetric() && (distanceKm / KM_TO_MILES_FACTOR) < 1
                    ) ||
            (displayUnits == DisplayUnits.IMPERIAL && (distanceKm / KM_TO_MILES_FACTOR) < 1)
}

/**
 * Checks if the metric display unit is enabled based on the display units setting and system locale.
 *
 * @param displayUnits The display units setting.
 * @return `true` if the metric system is enabled, `false` otherwise.
 */
private fun isMetricDisplayUnitEnabled(displayUnits: DisplayUnits): Boolean {
    return (displayUnits == DisplayUnits.SYSTEM && Locale.getDefault().isMetric()) ||
            displayUnits == DisplayUnits.METRIC
}

/**
 * Extension function for Locale to determine if it uses the metric system.
 *
 * @return `true` if the locale uses the metric system, `false` if it uses the imperial system.
 */
internal fun Locale.isMetric(): Boolean {
    return !imperialCountries.contains(country.uppercase(this))
}
