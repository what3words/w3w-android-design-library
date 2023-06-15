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

internal fun formatUnits(distanceKm: Int, displayUnits: DisplayUnits, context: Context): String {
    if (distanceKm == 0 ||
        (
                displayUnits == DisplayUnits.SYSTEM && !Locale.getDefault()
                    .isMetric() && (distanceKm / 1.609) < 1
                ) ||
        (displayUnits == DisplayUnits.IMPERIAL && (distanceKm / 1.609) < 1)
    ) {
        if ((displayUnits == DisplayUnits.SYSTEM && Locale.getDefault().isMetric()) ||
            displayUnits == DisplayUnits.METRIC
        ) {
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
        return if ((
                    displayUnits == DisplayUnits.SYSTEM && Locale.getDefault()
                        .isMetric()
                    ) || displayUnits == DisplayUnits.METRIC
        ) {
            val measureF = Measure(distanceKm, MeasureUnit.KILOMETER)
            fmtFr.format(measureF)
        } else {
            val measureF = Measure((distanceKm / 1.609).roundToInt(), MeasureUnit.MILE)
            fmtFr.format(measureF)
        }
    }
}

internal fun Locale.isMetric(): Boolean {
    return when (country.uppercase(this)) {
        "US", "LR", "MM", "BS", "BZ", "KY", "PW", "GB", "UK" -> false
        else -> true
    }
}
