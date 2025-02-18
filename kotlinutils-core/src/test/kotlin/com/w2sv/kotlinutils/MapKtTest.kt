package com.w2sv.kotlinutils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class MapKtTest {

    @Test
    fun `test filterTrueKeys`() {
        val map = mapOf("A" to true, "B" to false, "C" to true)
        val result = map.filterTrueKeys()
        assertEquals(setOf("A", "C"), result)
    }

    @Test
    fun `test toggle existing key`() {
        val map = mutableMapOf("A" to true, "B" to false)
        map.toggle("A")
        map.toggle("B")
        assertEquals(mapOf("A" to false, "B" to true), map)
    }

    @Test(expected = NoSuchElementException::class)
    fun `test toggle non-existent key throws exception`() {
        val map = mutableMapOf("A" to true)
        map.toggle("B") // Should throw NoSuchElementException
    }

    @Test
    fun `test map transformation`() {
        val map = mapOf(1 to "one", 2 to "two")
        val transformed = map.map { (key, value) -> key.toString() to value.length }
        assertEquals(mapOf("1" to 3, "2" to 3), transformed)
    }

    @Test
    fun `test copy transformation`() {
        val original = mapOf("A" to 1, "B" to 2)
        val copied = original.copy { this["C"] = 3 }
        assertEquals(mapOf("A" to 1, "B" to 2, "C" to 3), copied)
        assertEquals(mapOf("A" to 1, "B" to 2), original) // Ensure original is unchanged
    }

    @Test
    fun `test update key value`() {
        val map = mutableMapOf("A" to 1, "B" to 2)
        map.update("A") { it + 10 }
        assertEquals(mapOf("A" to 11, "B" to 2), map)
    }

    @Test(expected = NoSuchElementException::class)
    fun `test update non-existent key throws exception`() {
        val map = mutableMapOf("A" to 1)
        map.update("B") { it + 10 } // Should throw NoSuchElementException
    }
}
