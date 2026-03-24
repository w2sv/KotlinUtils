package com.w2sv.kotlinutils.coroutines

import junit.framework.TestCase.assertEquals
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

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
        assertThrows(CancellationException::class.java) {
            runTest { runCatchingCancellable { throw CancellationException() } }
        }
    }
}
