package com.what3words.design.library.ui.models

import android.content.Context
import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

/** Whole kilometres: 0 is the only value that hides a real distance, so it is the only `<1 km`. */
@RunWith(RobolectricTestRunner::class)
class FormatUnitsTest {

    private lateinit var originalLocale: Locale
    private lateinit var context: Context

    @Before
    fun setUp() {
        originalLocale = Locale.getDefault()
        // formatUnits has no locale parameter, so it resolves Locale.getDefault().
        Locale.setDefault(Locale.ENGLISH)
        context = RuntimeEnvironment.getApplication()
    }

    @After
    fun tearDown() {
        Locale.setDefault(originalLocale)
    }

    private fun String.normalized() = replace('\u00A0', ' ').replace('\u202F', ' ')

    private fun format(distanceKm: Int, displayUnits: DisplayUnits) =
        formatUnits(distanceKm, displayUnits, context).normalized()

    @Test
    fun `only zero renders the below-one form`() {
        assertThat(format(0, DisplayUnits.METRIC)).isEqualTo("<1 km")
        assertThat(format(0, DisplayUnits.IMPERIAL)).isEqualTo("<1 mi")
    }

    @Test
    fun `non-zero shows the real value`() {
        assertThat(format(1, DisplayUnits.METRIC)).isEqualTo("1 km")
        assertThat(format(20, DisplayUnits.METRIC)).isEqualTo("20 km")
        // 1 km is known to kilometre precision, so 0.62 mi is no longer hidden behind "<1 mi".
        assertThat(format(1, DisplayUnits.IMPERIAL)).isEqualTo("0.62 mi")
        assertThat(format(20, DisplayUnits.IMPERIAL)).isEqualTo("12.4 mi")
    }

    @Test
    fun `non-zero agrees with formatDistance exactly`() {
        for (km in listOf(1, 2, 20, 137, 1234)) {
            for (units in listOf(DisplayUnits.METRIC, DisplayUnits.IMPERIAL)) {
                assertThat(format(km, units))
                    .isEqualTo(formatDistance(km.toDouble(), units).normalized())
            }
        }
    }

    @Test
    fun `system units follow the locale`() {
        Locale.setDefault(Locale.US)
        assertThat(format(0, DisplayUnits.SYSTEM)).isEqualTo("<1 mi")
        assertThat(format(20, DisplayUnits.SYSTEM)).isEqualTo("12.4 mi")

        Locale.setDefault(Locale.GERMANY)
        assertThat(format(0, DisplayUnits.SYSTEM)).isEqualTo("<1 km")
        assertThat(format(20, DisplayUnits.SYSTEM)).isEqualTo("20 km")
    }
}
