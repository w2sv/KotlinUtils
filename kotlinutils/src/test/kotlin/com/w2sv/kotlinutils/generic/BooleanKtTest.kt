package com.w2sv.kotlinutils.generic

import org.junit.Assert.assertEquals
import org.junit.Test

class BooleanKtTest {

    @Test
    fun asInt() {
        assertEquals(0, false.asInt)
        assertEquals(1, true.asInt)
    }

    @Test
    fun asSignedInt() {
        assertEquals(-1, false.asSignedInt)
        assertEquals(1, true.asSignedInt)
    }
}