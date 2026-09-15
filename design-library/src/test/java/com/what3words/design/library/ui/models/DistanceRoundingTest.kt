package com.what3words.design.library.ui.models

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Pure-JVM coverage of the numeric rule behind [formatDistance], ported from iOS
 * `W3WDistance.asString(format:system:)`. No Android or ICU involvement, so this runs on the JVM
 * and is the safety net for the part most likely to regress.
 */
class DistanceRoundingTest {

    private fun assertRounds(value: Double, expected: Double, expectedDigits: Int) {
        val (rounded, digits) = roundForDisplay(value)
        assertEquals("fraction digits for $value", expectedDigits, digits)
        assertEquals("rounded value for $value", expected, rounded, 1e-9)
    }

    @Test
    fun `below one uses two decimals`() {
        assertRounds(0.0, 0.0, 2)
        assertRounds(0.004, 0.0, 2)
        assertRounds(0.005, 0.01, 2)
        assertRounds(0.01, 0.01, 2)
        assertRounds(0.015, 0.02, 2)
        assertRounds(0.1234, 0.12, 2)
        assertRounds(0.5, 0.5, 2)
        assertRounds(0.999, 1.0, 2)
    }

    @Test
    fun `one to ten uses two decimals`() {
        assertRounds(1.0, 1.0, 2)
        assertRounds(1.4, 1.4, 2)
        assertRounds(1.456, 1.46, 2)
        assertRounds(9.994, 9.99, 2)
        assertRounds(9.999, 10.0, 2)
    }

    @Test
    fun `ten to one hundred uses one decimal`() {
        assertRounds(10.0, 10.0, 1)
        assertRounds(12.34, 12.3, 1)
        assertRounds(12.6, 12.6, 1)
        assertRounds(99.94, 99.9, 1)
        assertRounds(99.96, 100.0, 1)
    }

    @Test
    fun `one hundred and above uses no decimals`() {
        assertRounds(100.0, 100.0, 0)
        assertRounds(123.4, 123.0, 0)
        assertRounds(123.5, 124.0, 0)
        assertRounds(1234.0, 1234.0, 0)
        assertRounds(40075.0, 40075.0, 0)
    }

    /**
     * iOS rounds the scaled binary `Double`, so `0.145` — whose nearest `Double` is just below
     * `0.145` — rounds *down*. Going via `BigDecimal` would round the decimal literal up to `0.15`
     * and diverge from iOS. 145 m is a perfectly ordinary distance, so this is reachable.
     */
    @Test
    fun `decimal ties follow iOS binary rounding, not BigDecimal`() {
        assertRounds(0.145, 0.14, 2)
        assertRounds(0.285, 0.28, 2)
        assertRounds(1.005, 1.0, 2)
        assertRounds(1.255, 1.25, 2)
    }

    /**
     * The Swift applies its magnitude-dependent rounding *first* and a 2 dp clamp second (which is
     * therefore inert). Clamping to 2 dp first would give `12.5` here.
     */
    @Test
    fun `rounds once, magnitude first`() {
        assertRounds(12.449, 12.4, 1)
        assertRounds(123.496, 123.0, 0)
    }
}
