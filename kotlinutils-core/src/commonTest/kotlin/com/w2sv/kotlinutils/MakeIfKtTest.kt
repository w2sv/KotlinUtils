package com.w2sv.kotlinutils

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class MakeIfKtTest {

    @Test
    fun `makeIf returns value only when condition is true`() {
        var executed = false

        val resultTrue = makeIf(true) {
            executed = true
            "value"
        }

        assertEquals("value", resultTrue)
        assertTrue(executed)

        executed = false

        val resultFalse = makeIf(false) {
            executed = true
            "value"
        }

        assertNull(resultFalse)
        assertFalse(executed)
    }
}
