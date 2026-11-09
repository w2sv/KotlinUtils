package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertSame
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
    fun `returns failure when block throws an exception`() =
        runTest {
            val failure = IllegalStateException("boom")

            val result = runCatchingCancellable<Int> { throw failure }

            assertSame(failure, result.exceptionOrNull())
        }

    @Test
    fun `rethrows the original CancellationException`() =
        runTest {
            val cancellation = CancellationException("cancelled")

            val thrown = assertFailsWith<CancellationException> {
                runCatchingCancellable { throw cancellation }
            }

            assertSame(cancellation, thrown)
        }

    @Test
    fun `invokes onCancellation before rethrowing`() =
        runTest {
            val cancellation = CancellationException("cancelled")
            var observed: CancellationException? = null
            var calls = 0

            val thrown = assertFailsWith<CancellationException> {
                runCatchingCancellable(
                    onCancellation = {
                        observed = it
                        calls++
                    }
                ) { throw cancellation }
            }

            assertSame(cancellation, observed)
            assertSame(cancellation, thrown)
            assertEquals(1, calls)
        }

    @Test
    fun `does not invoke onCancellation on success or ordinary failure`() =
        runTest {
            var called = false
            val onCancellation: (CancellationException) -> Unit = { called = true }

            runCatchingCancellable(onCancellation = onCancellation) { 42 }
            runCatchingCancellable(onCancellation = onCancellation) {
                throw IllegalStateException("boom")
            }

            assertFalse(called)
        }

    @Test
    fun `preserves cancellation if onCancellation throws`() =
        runTest {
            val cancellation = CancellationException("cancelled")
            val callbackFailure = IllegalStateException("callback failed")

            val thrown = assertFailsWith<CancellationException> {
                runCatchingCancellable(
                    onCancellation = { throw callbackFailure }
                ) { throw cancellation }
            }

            assertSame(cancellation, thrown)
            assertEquals(1, thrown.suppressedExceptions.size)
            assertSame(callbackFailure, thrown.suppressedExceptions.single())
        }

    @Test
    fun `does not suppress cancellation onto itself`() =
        runTest {
            val cancellation = CancellationException("cancelled")

            val thrown = assertFailsWith<CancellationException> {
                runCatchingCancellable(
                    onCancellation = { throw cancellation }
                ) { throw cancellation }
            }

            assertSame(cancellation, thrown)
            assertTrue(thrown.suppressedExceptions.isEmpty())
        }

    @Test
    fun `propagates Throwable that is not an Exception`() =
        runTest {
            val fatal = Throwable("fatal")

            val thrown = assertFailsWith<Throwable> {
                runCatchingCancellable { throw fatal }
            }

            assertSame(fatal, thrown)
        }
}
