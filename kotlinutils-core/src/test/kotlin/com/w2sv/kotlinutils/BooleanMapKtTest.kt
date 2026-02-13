package com.w2sv.kotlinutils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class BooleanMapKtTest {

    @Test
    fun trueKeys() {
        assertEquals(
            listOf("A", "C"),
            mapOf("A" to true, "B" to false, "C" to true).trueKeys()
        )
    }

    @Test
    fun trueKeysSet() {
        assertEquals(
            setOf("A", "C"),
            mapOf("A" to true, "B" to false, "C" to true).trueKeysSet()
        )
    }

    @Test
    fun `toggle existing key`() {
        val map = mutableMapOf("A" to true, "B" to false)
        map.toggle("A")
        map.toggle("B")
        assertEquals(mapOf("A" to false, "B" to true), map)
    }

    @Test(expected = NoSuchElementException::class)
    fun `toggle non-existent key throws exception`() {
        mutableMapOf("A" to true).toggle("B") // Should throw NoSuchElementException
    }
}
