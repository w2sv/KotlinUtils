package com.w2sv.kotlinutils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class SetExtensionsTest {

    @Test
    fun testFilterToSet() {
        assertEquals(setOf(2, 4), setOf(1, 2, 3, 4, 5).filterToSet { it % 2 == 0 })
    }

    @Test
    fun testFilterNotToSet() {
        assertEquals(setOf(1, 3, 5), setOf(1, 2, 3, 4, 5).filterNotToSet { it % 2 == 0 })
    }
}
