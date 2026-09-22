package com.what3words.design.library.ui.models

import android.content.Context
import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@Suppress("DEPRECATION")
@RunWith(RobolectricTestRunner::class)
class FormatUnitsDeprecatedTest {

    private val context: Context = RuntimeEnvironment.getApplication()

    private fun String.normalized() = replace('\u00A0', ' ').replace('\u202F', ' ')

    @Test
    fun `zero kilometres keeps the legacy below-one-unit form`() {
        assertThat(formatUnits(0, DisplayUnits.METRIC, context).normalized()).isEqualTo("<1 km")
        assertThat(formatUnits(0, DisplayUnits.IMPERIAL, context).normalized()).isEqualTo("<1 mi")
    }

    @Test
    fun `non-zero kilometres render the real value`() {
        assertThat(formatUnits(1, DisplayUnits.METRIC, context).normalized()).isEqualTo("1 km")
        assertThat(formatUnits(20, DisplayUnits.METRIC, context).normalized()).isEqualTo("20 km")
        assertThat(formatUnits(1234, DisplayUnits.METRIC, context).normalized())
            .isEqualTo("1,234 km")
    }

    @Test
    fun `the metre and kilometre entry points never emit the legacy form`() {
        assertThat(formatDistanceKm(0.0, DisplayUnits.METRIC, locale = Locale.ENGLISH))
            .isEqualTo("0 km")
        assertThat(formatDistanceKm(0.34, DisplayUnits.METRIC, locale = Locale.ENGLISH))
            .isEqualTo("0.34 km")
    }
}
