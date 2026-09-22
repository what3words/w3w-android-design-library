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
        meters: Int,
        displayUnits: DisplayUnits,
        locale: Locale,
        expected: String
    ) {
        assertThat(formatDistance(meters, displayUnits, locale = locale).normalized())
            .isEqualTo(expected)
    }

    @Test
    fun `metric renders the accurate value with no lower threshold`() {
        val l = Locale.ENGLISH
        assertFormats(0, DisplayUnits.METRIC, l, "0 km")
        assertFormats(4, DisplayUnits.METRIC, l, "0 km")
        assertFormats(5, DisplayUnits.METRIC, l, "0.01 km")
        // MT-9374: these three used to render "<1 km".
        assertFormats(10, DisplayUnits.METRIC, l, "0.01 km")
        assertFormats(137, DisplayUnits.METRIC, l, "0.14 km")
        assertFormats(340, DisplayUnits.METRIC, l, "0.34 km")
        assertFormats(500, DisplayUnits.METRIC, l, "0.5 km")
        assertFormats(999, DisplayUnits.METRIC, l, "1 km")
    }

    @Test
    fun `metric decimals shrink as the magnitude grows`() {
        val l = Locale.ENGLISH
        assertFormats(1_000, DisplayUnits.METRIC, l, "1 km")
        assertFormats(1_400, DisplayUnits.METRIC, l, "1.4 km")
        assertFormats(1_456, DisplayUnits.METRIC, l, "1.46 km")
        assertFormats(9_999, DisplayUnits.METRIC, l, "10 km")
        assertFormats(12_340, DisplayUnits.METRIC, l, "12.3 km")
        assertFormats(12_600, DisplayUnits.METRIC, l, "12.6 km")
        assertFormats(20_000, DisplayUnits.METRIC, l, "20 km")
        assertFormats(99_960, DisplayUnits.METRIC, l, "100 km")
        assertFormats(123_400, DisplayUnits.METRIC, l, "123 km")
        assertFormats(1_234_000, DisplayUnits.METRIC, l, "1,234 km")
    }

    @Test
    fun `imperial converts via KM_TO_MILES_FACTOR`() {
        val l = Locale.US
        assertFormats(0, DisplayUnits.IMPERIAL, l, "0 mi")
        assertFormats(5, DisplayUnits.IMPERIAL, l, "0 mi")
        assertFormats(100, DisplayUnits.IMPERIAL, l, "0.06 mi")
        assertFormats(340, DisplayUnits.IMPERIAL, l, "0.21 mi")
        assertFormats(1_000, DisplayUnits.IMPERIAL, l, "0.62 mi")
        assertFormats(1_609, DisplayUnits.IMPERIAL, l, "1 mi")
        assertFormats(16_093, DisplayUnits.IMPERIAL, l, "10 mi")
        assertFormats(20_000, DisplayUnits.IMPERIAL, l, "12.4 mi")
        assertFormats(200_000, DisplayUnits.IMPERIAL, l, "124 mi")
        assertFormats(2_000_000, DisplayUnits.IMPERIAL, l, "1,243 mi")
    }

    @Test
    fun `decimals are applied after conversion, not before`() {
        // 20 km is 1-decimal territory in km but also in miles, and the two disagree on the value.
        assertFormats(20_000, DisplayUnits.METRIC, Locale.ENGLISH, "20 km")
        assertFormats(20_000, DisplayUnits.IMPERIAL, Locale.US, "12.4 mi")
    }

    @Test
    fun `system units follow the locale`() {
        assertFormats(20_000, DisplayUnits.SYSTEM, Locale.US, "12.4 mi")
        assertFormats(20_000, DisplayUnits.SYSTEM, Locale.UK, "12.4 mi")
        assertFormats(20_000, DisplayUnits.SYSTEM, Locale.GERMANY, "20 km")
        assertFormats(20_000, DisplayUnits.SYSTEM, Locale.FRANCE, "20 km")
        assertFormats(20_000, DisplayUnits.SYSTEM, Locale.ENGLISH, "20 km")
        assertFormats(20_000, DisplayUnits.SYSTEM, Locale.forLanguageTag("en-LR"), "12.4 mi")
    }

    @Test
    fun `separators follow the locale`() {
        assertFormats(500, DisplayUnits.METRIC, Locale.GERMANY, "0,5 km")
        assertFormats(1_234_000, DisplayUnits.METRIC, Locale.GERMANY, "1.234 km")
        assertFormats(500, DisplayUnits.METRIC, Locale.FRANCE, "0,5 km")
    }

    @Test
    fun `unit name is localised`() {
        // ar uses Arabic-Indic numerals and a localised unit name; assert against ICU itself rather
        // than a literal so the test does not pin one ICU version's exact glyphs.
        val arabic = formatDistance(500, DisplayUnits.METRIC, locale = Locale.forLanguageTag("ar-EG"))
        val expectedNumber =
            android.icu.text.NumberFormat.getInstance(Locale.forLanguageTag("ar-EG")).format(0.5)
        assertThat(arabic).contains(expectedNumber)
        assertThat(arabic).doesNotContain("0.5")
    }
}
