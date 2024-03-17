package com.w2sv.kotlinutils.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class BooleanKtTest {

    @Test
    fun toInt() {
        assertEquals(0, false.toInt())
        assertEquals(1, true.toInt())
    }

    @Test
    fun toNonZeroInt() {
        assertEquals(-1, false.toNonZeroInt())
        assertEquals(1, true.toNonZeroInt())
    }
}