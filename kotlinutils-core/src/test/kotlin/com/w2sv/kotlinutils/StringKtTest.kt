package com.w2sv.kotlinutils

import org.junit.Assert.assertEquals
import org.junit.Test

class StringKtTest {

    @Test
    fun capitalize() {
        assertEquals("Ayran", "ayran".capitalize())
        assertEquals("AYRAN", "aYRAN".capitalize())
        assertEquals("AYRAN", "AYRAN".capitalize())
    }
}
