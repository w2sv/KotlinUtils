package com.w2sv.kotlinutils.extensions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StringKtTest {

    @ParameterizedTest
    @CsvSource(
        "ayran, Ayran",
        "aYRAN, AYRAN",
        "AYRAN, AYRAN",
    )
    fun capitalized(string: String, expected: String) {
        Assertions.assertEquals(expected, string.capitalized())
    }
}