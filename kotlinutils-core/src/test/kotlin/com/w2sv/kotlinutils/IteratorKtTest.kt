package com.w2sv.kotlinutils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class IteratorKtTest {

    @Test
    fun `nextPair should return next two elements as a Pair`() {
        val iterator = listOf("a", "b", "c").iterator()
        val pair = iterator.nextPair()

        assertEquals(Pair("a", "b"), pair)
        assertEquals("c", iterator.next()) // The third element should still be next
    }

    @Test
    fun `nextPair should throw NoSuchElementException if not enough elements`() {
        val iterator = listOf(1).iterator()
        assertThrows(NoSuchElementException::class.java) {
            iterator.nextPair()
        }
    }

    @Test
    fun `nextTriple should return next three elements as a Triple`() {
        val iterator = listOf(10, 20, 30, 40).iterator()
        val triple = iterator.nextTriple()

        assertEquals(Triple(10, 20, 30), triple)
        assertEquals(40, iterator.next()) // Remaining element
    }

    @Test
    fun `nextTriple should throw NoSuchElementException if not enough elements`() {
        val iterator = listOf(1, 2).iterator()
        assertThrows(NoSuchElementException::class.java) {
            iterator.nextTriple()
        }
    }
}
