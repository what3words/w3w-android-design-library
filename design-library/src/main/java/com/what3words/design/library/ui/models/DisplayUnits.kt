package com.what3words.design.library.ui.models

import android.content.Context
import android.icu.text.MeasureFormat
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import com.what3words.design.library.R
import java.util.Locale
import kotlin.math.roundToInt

enum class DisplayUnits {
    SYSTEM, IMPERIAL, METRIC
}

private const val KM_TO_MILES_FACTOR = 1.609
private val imperialCountries = hashSetOf("US", "LR", "MM", "BS", "BZ", "KY", "PW", "GB", "UK")

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

private fun isMetricDisplayUnitEnabled(displayUnits: DisplayUnits): Boolean {
    return (displayUnits == DisplayUnits.SYSTEM && Locale.getDefault().isMetric()) ||
            displayUnits == DisplayUnits.METRIC
}

internal fun Locale.isMetric(): Boolean {
    return !imperialCountries.contains(country.uppercase(this))
}
