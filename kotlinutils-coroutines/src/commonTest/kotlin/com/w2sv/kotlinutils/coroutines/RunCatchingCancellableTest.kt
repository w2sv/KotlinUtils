package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest

class RunCatchingCancellableTest {

    @Test
    fun `returns success when block succeeds`() =
        runTest {
            val result = runCatchingCancellable { 42 }
            assertEquals(42, result.getOrNull())
        }

    @Test
    fun `returns failure when block throws`() =
        runTest {
            val result = runCatchingCancellable { error("boom") }
            assertTrue(result.exceptionOrNull() is IllegalStateException)
        }

    @Test
    fun `rethrows CancellationException`() {
        assertFailsWith<CancellationException> {
            runTest { runCatchingCancellable { throw CancellationException() } }
        }
    }
}
