package com.w2sv.kotlinutils

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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

    @Test
    fun `toggle non-existent key throws exception`() {
        assertFailsWith<NoSuchElementException> { mutableMapOf("A" to true).toggle("B") }
    }
}
