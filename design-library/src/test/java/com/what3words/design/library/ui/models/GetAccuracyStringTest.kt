package com.what3words.design.library.ui.models

import com.google.common.truth.Truth.assertThat
import java.util.Locale
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * [getAccuracyString] is consumed externally by w3w-android-map-components, so its signature and
 * unit-switching behaviour are pinned here. Only its conversion constants changed.
 */
@RunWith(RobolectricTestRunner::class)
class GetAccuracyStringTest {

    private lateinit var originalLocale: Locale

    @Before
    fun setUp() {
        originalLocale = Locale.getDefault()
        // getAccuracyString has no locale parameter, so it resolves Locale.getDefault().
        Locale.setDefault(Locale.ENGLISH)
    }

    @After
    fun tearDown() {
        Locale.setDefault(originalLocale)
    }

    private fun String.normalized() = replace('\u00A0', ' ').replace('\u202F', ' ')

    @Test
    fun `metric switches from metres to kilometres at one kilometre`() {
        assertThat(getAccuracyString(5f, DisplayUnits.METRIC).normalized()).isEqualTo("5 m")
        assertThat(getAccuracyString(999f, DisplayUnits.METRIC).normalized()).isEqualTo("999 m")
        assertThat(getAccuracyString(1000f, DisplayUnits.METRIC).normalized()).isEqualTo("1 km")
        assertThat(getAccuracyString(1500f, DisplayUnits.METRIC).normalized()).isEqualTo("2 km")
    }

    @Test
    fun `imperial switches from feet to miles at one mile`() {
        assertThat(getAccuracyString(100f, DisplayUnits.IMPERIAL).normalized()).isEqualTo("328 ft")
        assertThat(getAccuracyString(1610f, DisplayUnits.IMPERIAL).normalized()).isEqualTo("1 mi")
        assertThat(getAccuracyString(3219f, DisplayUnits.IMPERIAL).normalized()).isEqualTo("2 mi")
    }

    /**
     * Regression test for the conversion factor. The old code reached feet via
     * `metres / 1000 / 1.609 * 5280`, giving 5,251 ft; the exact factors give 5,249 ft.
     */
    @Test
    fun `feet use the exact conversion factor`() {
        assertThat(getAccuracyString(1600f, DisplayUnits.IMPERIAL).normalized())
            .isEqualTo("5,249 ft")
    }
}
