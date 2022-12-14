package com.w2sv.kotlinutils.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class FloatKtTest {
    @ParameterizedTest
    @CsvSource(
        "43.987234, 3, 43.987",
        "43.987234, 2, 43.99",
        "43.987234, 1, 44.0",
        "43.987234, 0, 44",
        "1.1, 1, 1.1",
        "1.1, 0, 1",
        "1.49999, 0, 1",
        "1.5, 0, 2"
    )
    fun rounded(float: Float, nDecimals: Int, expected: String) {
        assertEquals(expected, float.rounded(nDecimals))
    }
}