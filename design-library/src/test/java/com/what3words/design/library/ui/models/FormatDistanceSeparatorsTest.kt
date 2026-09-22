package com.what3words.design.library.ui.models

import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Coverage of the [formatDistance] overload that carries explicit separators.
 *
 * The six combinations asserted here are exactly the ones the app's separator preference can
 * produce, and they mirror iOS `W3WSeparatorsType`. Needs Robolectric because `android.icu.*` is
 * an Android framework package.
 */
@RunWith(RobolectricTestRunner::class)
class FormatDistanceSeparatorsTest {

    /** ICU's SHORT unit patterns use non-breaking spaces in several locales. */
    private fun String.normalized() = replace('\u00A0', ' ').replace('\u202F', ' ')

    private fun format(
        meters: Int,
        grouping: Char?,
        decimal: Char,
        displayUnits: DisplayUnits = DisplayUnits.METRIC,
        locale: Locale = Locale.ENGLISH
    ) = formatDistanceKm(
        meters / 1000.0,
        displayUnits,
        DistanceSeparators(grouping, decimal),
        locale = locale
    ).normalized()

    // A value that groups (>= 1000, so 0 decimals) and one that shows decimals (< 10).
    private val grouped = 1_234_000
    private val fractional = 340

    @Test
    fun `option 1 - comma grouping, dot decimal`() {
        assertThat(format(grouped, ',', '.')).isEqualTo("1,234 km")
        assertThat(format(fractional, ',', '.')).isEqualTo("0.34 km")
    }

    @Test
    fun `option 2 - dot grouping, comma decimal`() {
        assertThat(format(grouped, '.', ',')).isEqualTo("1.234 km")
        assertThat(format(fractional, '.', ',')).isEqualTo("0,34 km")
    }

    @Test
    fun `option 3 - space grouping, dot decimal`() {
        assertThat(format(grouped, ' ', '.')).isEqualTo("1 234 km")
        assertThat(format(fractional, ' ', '.')).isEqualTo("0.34 km")
    }

    @Test
    fun `option 4 - space grouping, comma decimal`() {
        assertThat(format(grouped, ' ', ',')).isEqualTo("1 234 km")
        assertThat(format(fractional, ' ', ',')).isEqualTo("0,34 km")
    }

    @Test
    fun `option 5 - no grouping, dot decimal`() {
        assertThat(format(grouped, null, '.')).isEqualTo("1234 km")
        assertThat(format(fractional, null, '.')).isEqualTo("0.34 km")
    }

    @Test
    fun `option 6 - no grouping, comma decimal`() {
        assertThat(format(grouped, null, ',')).isEqualTo("1234 km")
        assertThat(format(fractional, null, ',')).isEqualTo("0,34 km")
    }

    @Test
    fun `separators override the locale's own`() {
        // German would render "1.234 km" and "0,34 km" on its own; the arguments win.
        assertThat(format(grouped, ',', '.', locale = Locale.GERMANY)).isEqualTo("1,234 km")
        assertThat(format(fractional, ',', '.', locale = Locale.GERMANY)).isEqualTo("0.34 km")
    }

    @Test
    fun `the unit name still follows the locale`() {
        // Only the separators are overridden, never the unit or the digits.
        assertThat(format(fractional, ',', '.', locale = Locale.FRANCE)).isEqualTo("0.34 km")
    }

    @Test
    fun `imperial honours the separators after conversion`() {
        assertThat(format(2_000_000, ' ', ',', DisplayUnits.IMPERIAL, Locale.US))
            .isEqualTo("1 243 mi")
        assertThat(format(340, ' ', ',', DisplayUnits.IMPERIAL, Locale.US))
            .isEqualTo("0,21 mi")
    }

    @Test
    fun `the decimals rule is unaffected by the separators`() {
        assertThat(format(0, ',', '.')).isEqualTo("0 km")
        assertThat(format(4, ',', '.')).isEqualTo("0 km")
        assertThat(format(10, ',', '.')).isEqualTo("0.01 km")
        assertThat(format(999, ',', '.')).isEqualTo("1 km")
        assertThat(format(1_400, ',', '.')).isEqualTo("1.4 km")
        assertThat(format(12_600, ',', '.')).isEqualTo("12.6 km")
        assertThat(format(123_400, ',', '.')).isEqualTo("123 km")
    }

    @Test
    fun `grouping is applied even in locales that suppress it by default`() {
        // CLDR gives some locales minimumGroupingDigits = 2, which would leave 4-digit numbers
        // ungrouped. Android's ICU data groups them, so this matches iOS, which groups
        // unconditionally. Pinned here because it is the behaviour parity depends on.
        val es = Locale("es", "ES")
        assertThat(format(grouped, ',', '.', locale = es)).isEqualTo("1,234 km")
        assertThat(format(12_345_000, ',', '.', locale = es)).isEqualTo("12,345 km")
        assertThat(format(grouped, ' ', ',', locale = Locale("pl", "PL"))).isEqualTo("1 234 km")
    }

    @Test
    fun `localised digits and unit survive a forced separator`() {
        // Arabic uses Arabic-Indic digits and U+066B as its own decimal separator. Forcing '.'
        // must replace only the separator, leaving the digits and the unit name localised.
        val ar = Locale("ar", "EG")
        assertThat(format(fractional, ',', '.', locale = ar)).isEqualTo("\u0660.\u0663\u0664 \u0643\u0645")
        assertThat(formatDistanceKm(fractional / 1000.0, DisplayUnits.METRIC, locale = ar).normalized())
            .isEqualTo("\u0660\u066b\u0663\u0664 \u0643\u0645")
    }

    @Test
    fun `the locale-driven overload is unchanged`() {
        assertThat(formatDistanceKm(grouped / 1000.0, DisplayUnits.METRIC, locale = Locale.ENGLISH).normalized())
            .isEqualTo("1,234 km")
        assertThat(formatDistanceKm(grouped / 1000.0, DisplayUnits.METRIC, locale = Locale.GERMANY).normalized())
            .isEqualTo("1.234 km")
    }
}
