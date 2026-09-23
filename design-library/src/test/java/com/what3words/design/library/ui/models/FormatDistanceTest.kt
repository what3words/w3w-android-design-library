package com.what3words.design.library.ui.models

import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Rendered-string coverage of [formatDistance]. Needs Robolectric because `android.icu.*` is an
 * Android framework package and throws `Stub!` against the `android.jar` stubs.
 */
@RunWith(RobolectricTestRunner::class)
class FormatDistanceTest {

    /** ICU's SHORT unit patterns use non-breaking spaces in several locales. */
    private fun String.normalized() = replace('\u00A0', ' ').replace('\u202F', ' ')

    private fun assertFormats(
        km: Double,
        displayUnits: DisplayUnits,
        locale: Locale,
        expected: String
    ) {
        assertThat(formatDistance(km, displayUnits, locale = locale).normalized())
            .isEqualTo(expected)
    }

    @Test
    fun `metric renders the accurate value with no lower threshold`() {
        val l = Locale.ENGLISH
        assertFormats(0.0, DisplayUnits.METRIC, l, "0 km")
        assertFormats(0.004, DisplayUnits.METRIC, l, "0 km")
        assertFormats(0.005, DisplayUnits.METRIC, l, "0.01 km")
        // MT-9374: these three used to render "<1 km".
        assertFormats(0.01, DisplayUnits.METRIC, l, "0.01 km")
        assertFormats(0.137, DisplayUnits.METRIC, l, "0.14 km")
        assertFormats(0.34, DisplayUnits.METRIC, l, "0.34 km")
        assertFormats(0.5, DisplayUnits.METRIC, l, "0.5 km")
        assertFormats(0.999, DisplayUnits.METRIC, l, "1 km")
    }

    @Test
    fun `metric decimals shrink as the magnitude grows`() {
        val l = Locale.ENGLISH
        assertFormats(1.0, DisplayUnits.METRIC, l, "1 km")
        assertFormats(1.4, DisplayUnits.METRIC, l, "1.4 km")
        assertFormats(1.456, DisplayUnits.METRIC, l, "1.46 km")
        assertFormats(9.999, DisplayUnits.METRIC, l, "10 km")
        assertFormats(12.34, DisplayUnits.METRIC, l, "12.3 km")
        assertFormats(12.6, DisplayUnits.METRIC, l, "12.6 km")
        assertFormats(20.0, DisplayUnits.METRIC, l, "20 km")
        assertFormats(99.96, DisplayUnits.METRIC, l, "100 km")
        assertFormats(123.4, DisplayUnits.METRIC, l, "123 km")
        assertFormats(1234.0, DisplayUnits.METRIC, l, "1,234 km")
    }

    @Test
    fun `imperial converts at the exact mile factor`() {
        val l = Locale.US
        assertFormats(0.0, DisplayUnits.IMPERIAL, l, "0 mi")
        assertFormats(0.005, DisplayUnits.IMPERIAL, l, "0 mi")
        assertFormats(0.1, DisplayUnits.IMPERIAL, l, "0.06 mi")
        assertFormats(0.34, DisplayUnits.IMPERIAL, l, "0.21 mi")
        assertFormats(1.0, DisplayUnits.IMPERIAL, l, "0.62 mi")
        assertFormats(1.609, DisplayUnits.IMPERIAL, l, "1 mi")
        assertFormats(16.093, DisplayUnits.IMPERIAL, l, "10 mi")
        // Previously rendered "12 mi" — the whole-kilometre API rounded to a whole number.
        assertFormats(20.0, DisplayUnits.IMPERIAL, l, "12.4 mi")
        assertFormats(200.0, DisplayUnits.IMPERIAL, l, "124 mi")
        assertFormats(2000.0, DisplayUnits.IMPERIAL, l, "1,243 mi")
    }

    @Test
    fun `the mile factor is exact, not 1_609`() {
        // 1.609 would give "3,108 mi".
        assertFormats(5000.0, DisplayUnits.IMPERIAL, Locale.US, "3,107 mi")
    }

    @Test
    fun `decimals are applied after conversion, not before`() {
        // 20 km is 1-decimal territory in km but also in miles, and the two disagree on the value.
        assertFormats(20.0, DisplayUnits.METRIC, Locale.ENGLISH, "20 km")
        assertFormats(20.0, DisplayUnits.IMPERIAL, Locale.US, "12.4 mi")
    }

    @Test
    fun `system units follow the locale`() {
        assertFormats(20.0, DisplayUnits.SYSTEM, Locale.US, "12.4 mi")
        assertFormats(20.0, DisplayUnits.SYSTEM, Locale.UK, "12.4 mi")
        assertFormats(20.0, DisplayUnits.SYSTEM, Locale.GERMANY, "20 km")
        assertFormats(20.0, DisplayUnits.SYSTEM, Locale.FRANCE, "20 km")
        assertFormats(20.0, DisplayUnits.SYSTEM, Locale.ENGLISH, "20 km")
        assertFormats(20.0, DisplayUnits.SYSTEM, Locale.forLanguageTag("en-LR"), "12.4 mi")
    }

    @Test
    fun `separators follow the locale`() {
        assertFormats(0.5, DisplayUnits.METRIC, Locale.GERMANY, "0,5 km")
        assertFormats(1234.0, DisplayUnits.METRIC, Locale.GERMANY, "1.234 km")
        assertFormats(0.5, DisplayUnits.METRIC, Locale.FRANCE, "0,5 km")
    }

    @Test
    fun `unit name is localised`() {
        // ar uses Arabic-Indic numerals and a localised unit name; assert against ICU itself rather
        // than a literal so the test does not pin one ICU version's exact glyphs.
        val arabic = formatDistance(0.5, DisplayUnits.METRIC, locale = Locale.forLanguageTag("ar-EG"))
        val expectedNumber =
            android.icu.text.NumberFormat.getInstance(Locale.forLanguageTag("ar-EG")).format(0.5)
        assertThat(arabic).contains(expectedNumber)
        assertThat(arabic).doesNotContain("0.5")
    }

    @Test
    fun `non-finite values produce an empty string`() {
        val l = Locale.ENGLISH
        assertThat(formatDistance(Double.NaN, DisplayUnits.METRIC, locale = l)).isEmpty()
        assertThat(formatDistance(Double.POSITIVE_INFINITY, DisplayUnits.METRIC, locale = l))
            .isEmpty()
        assertThat(formatDistance(Double.NEGATIVE_INFINITY, DisplayUnits.IMPERIAL, locale = l))
            .isEmpty()
    }
}
