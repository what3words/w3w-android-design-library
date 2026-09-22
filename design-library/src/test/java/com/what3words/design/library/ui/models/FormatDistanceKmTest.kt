package com.what3words.design.library.ui.models

import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FormatDistanceKmTest {

    private fun String.normalized() = replace(' ', ' ').replace(' ', ' ')

    private fun format(
        km: Double,
        displayUnits: DisplayUnits = DisplayUnits.METRIC,
        locale: Locale = Locale.ENGLISH
    ) = formatDistanceKm(km, displayUnits, locale = locale).normalized()

    @Test
    fun `agrees with the metres overload for the same distance`() {
        listOf(0, 4, 10, 340, 999, 1_400, 12_600, 123_400, 1_234_000).forEach { meters ->
            assertThat(formatDistanceKm(meters / 1000.0, DisplayUnits.METRIC, locale = Locale.ENGLISH))
                .isEqualTo(formatDistance(meters, DisplayUnits.METRIC, locale = Locale.ENGLISH))
        }
    }

    @Test
    fun `the decimals rule applies to the kilometre value`() {
        assertThat(format(0.0)).isEqualTo("0 km")
        assertThat(format(0.004)).isEqualTo("0 km")
        assertThat(format(0.01)).isEqualTo("0.01 km")
        assertThat(format(0.145)).isEqualTo("0.14 km")
        assertThat(format(0.34)).isEqualTo("0.34 km")
        assertThat(format(0.5)).isEqualTo("0.5 km")
        assertThat(format(0.999)).isEqualTo("1 km")
        assertThat(format(1.4)).isEqualTo("1.4 km")
        assertThat(format(12.6)).isEqualTo("12.6 km")
        assertThat(format(123.4)).isEqualTo("123 km")
        assertThat(format(1234.0)).isEqualTo("1,234 km")
    }

    @Test
    fun `sub-metre precision survives`() {
        assertThat(format(0.0096)).isEqualTo("0.01 km")
        assertThat(format(0.0049)).isEqualTo("0 km")
        assertThat(format(1.4495)).isEqualTo("1.45 km")
    }

    @Test
    fun `imperial converts via KM_TO_MILES_FACTOR`() {
        assertThat(format(1.609, DisplayUnits.IMPERIAL, Locale.US)).isEqualTo("1 mi")
        assertThat(format(0.34, DisplayUnits.IMPERIAL, Locale.US)).isEqualTo("0.21 mi")
        assertThat(format(20.0, DisplayUnits.IMPERIAL, Locale.US)).isEqualTo("12.4 mi")
    }

    @Test
    fun `separators and locale still apply`() {
        assertThat(
            formatDistanceKm(
                1234.0,
                DisplayUnits.METRIC,
                DistanceSeparators(' ', ','),
                Locale.ENGLISH
            ).normalized()
        ).isEqualTo("1 234 km")
        assertThat(format(0.5, locale = Locale.GERMANY)).isEqualTo("0,5 km")
    }

    @Test
    fun `non-finite values produce an empty string`() {
        assertThat(format(Double.NaN)).isEmpty()
        assertThat(format(Double.POSITIVE_INFINITY)).isEmpty()
        assertThat(format(Double.NEGATIVE_INFINITY)).isEmpty()
    }
}
