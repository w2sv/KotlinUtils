package com.w2sv.kotlinutils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class MapKtTest {

    @Test
    fun filterTrueKeys() {
        assertEquals(
            setOf("A", "C"),
            mapOf("A" to true, "B" to false, "C" to true).filterTrueKeys()
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

    @Test
    fun map() {
        val map = mapOf(1 to "one", 2 to "two")
        val transformed = map.map { (key, value) -> key.toString() to value.length }
        assertEquals(mapOf("1" to 3, "2" to 3), transformed)
    }

    @Test
    fun copy() {
        val original = mapOf("A" to 1, "B" to 2)
        val copied = original.copy { this["C"] = 3 }
        assertEquals(mapOf("A" to 1, "B" to 2, "C" to 3), copied)
        assertEquals(mapOf("A" to 1, "B" to 2), original) // Ensure original is unchanged
    }

    @Test
    fun update() {
        assertEquals(
            mapOf("A" to 11, "B" to 2),
            mutableMapOf("A" to 1, "B" to 2).update("A") { it + 10 }
        )
    }

    @Test(expected = NoSuchElementException::class)
    fun `update non-existent key throws exception`() {
        mutableMapOf("A" to 1).update("B") { it + 10 } // Should throw NoSuchElementException
    }

    @Test
    fun `updateOrPut should update existing non-null value`() {
        val map = mutableMapOf("a" to 1, "b" to 2)
        val result = map.updateOrPut("a", transform = { it + 10 }, defaultValue = { 0 })

        assertEquals(mapOf("a" to 11, "b" to 2), result)
    }

    @Test
    fun `updateOrPut should insert value if key is not present`() {
        val map = mutableMapOf("x" to 100)
        val result = map.updateOrPut("y", transform = { it + 1 }, defaultValue = { 42 })

        assertEquals(mapOf("x" to 100, "y" to 42), result)
    }

    @Test
    fun `updateOrPut should insert value if key is present but null`() {
        val map = mutableMapOf<String, Int?>("k" to null)
        val result = map.updateOrPut("k", transform = { it!! + 5 }, defaultValue = { 99 })

        assertEquals(mapOf("k" to 99), result)
    }
}
