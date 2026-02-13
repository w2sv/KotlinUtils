package com.w2sv.kotlinutils.coroutines.flow

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CombineKtTest {

    @Test
    fun `combineToPair emits latest pairs`() =
        runTest {
            val flowA = flowOf(1, 2)
            val flowB = flowOf("a", "b")

            val result = combineToPair(flowA, flowB).toList()

            assertEquals(listOf(1 to "a", 2 to "b"), result)
        }
}
