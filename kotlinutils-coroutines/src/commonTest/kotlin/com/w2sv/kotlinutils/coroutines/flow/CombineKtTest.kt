package com.w2sv.kotlinutils.coroutines.flow

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest

class CombineKtTest {

    @Test
    fun `combineToPair emits latest pairs`() =
        runTest {
            val flowA = flowOf(1, 2)
            val flowB = flowOf("a", "b")

            val result = combineToPair(flowA, flowB).toList()

            assertEquals(listOf(1 to "a", 2 to "b"), result)
        }

    @Test
    fun `combineToTriple emits latest triples`() =
        runTest {
            val flowA = flowOf(1, 2)
            val flowB = flowOf("a", "b")
            val flowC = flowOf(true, false)

            val result = combineToTriple(flowA, flowB, flowC).toList()

            assertEquals(
                listOf(
                    Triple(1, "a", true),
                    Triple(2, "b", false)
                ),
                result
            )
        }
}
