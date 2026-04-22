package com.w2sv.kotlinutils

import kotlin.test.Test
import kotlin.test.assertEquals

class StringKtTest {

    @Test
    fun capitalize() {
        assertEquals("Ayran", "ayran".capitalize())
        assertEquals("AYRAN", "aYRAN".capitalize())
        assertEquals("AYRAN", "AYRAN".capitalize())
    }
}
