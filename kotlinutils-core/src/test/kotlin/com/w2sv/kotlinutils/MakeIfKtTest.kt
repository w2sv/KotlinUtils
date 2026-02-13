package com.w2sv.kotlinutils

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

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
