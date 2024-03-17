package com.w2sv.kotlinutils.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class StringKtTest {

    @Test
    fun capitalized() {
        assertEquals("Ayran", "ayran".capitalized())
        assertEquals("aYRAN", "AYRAN".capitalized())
        assertEquals("AYRAN", "AYRAN".capitalized())
    }
}