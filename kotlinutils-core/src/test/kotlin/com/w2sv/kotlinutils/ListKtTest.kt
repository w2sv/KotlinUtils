package com.w2sv.kotlinutils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ListKtTest {

    @Test
    fun `replaceLast replaces the last element on non-empty lists`() {
        assertEquals(listOf(1, 2, 8), listOf(1, 2, 3).copyWithReplacedLast(8))
    }

    @Test
    fun `replaceLast does not throw an error on empty lists`() {
        assertEquals(emptyList<Int>(), emptyList<Int>().copyWithReplacedLast(8))
    }

    @Test
    fun `copy should return a new list with updates applied`() {
        val original = listOf(1, 2, 3)
        val updated = original.copy {
            add(4)
            removeAt(0)
        }

        // Ensure the updated list is correct
        assertEquals(listOf(2, 3, 4), updated)

        // Ensure the original list is not modified
        assertEquals(listOf(1, 2, 3), original)
    }

    @Test
    fun `copy should return an identical list if no update is applied`() {
        val original = listOf("a", "b", "c")
        val updated = original.copy {
            // no changes
        }

        // Should be equal in content
        assertEquals(original, updated)

        // But not the same reference
        assert(original !== updated)
    }
}
