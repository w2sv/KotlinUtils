package com.w2sv.kotlinutils

import org.junit.Assert.assertEquals
import org.junit.Test

class FloatKtTest {

    @Test
    fun rounded() {
        assertEquals("43.987", 43.98723f.rounded(3))
        assertEquals("43.99", 43.98723f.rounded(2))
        assertEquals("44.0", 43.98723f.rounded(1))
        assertEquals("44", 43.98723f.rounded(0))
        assertEquals("1.1", 1.1f.rounded(1))
        assertEquals("1", 1.1f.rounded(0))
        assertEquals("1", 1.49999f.rounded(0))
        assertEquals("1.50", 1.5f.rounded(2))
    }
}
