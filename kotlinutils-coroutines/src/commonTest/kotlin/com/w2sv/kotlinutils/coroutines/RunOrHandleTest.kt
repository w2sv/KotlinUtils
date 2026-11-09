package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest

class RunOrHandleTest {

    @Test
    fun `runs block without invoking onFailure on success`() =
        runTest {
            var executed = false
            var failures = 0

            runOrHandle(onFailure = { failures++ }) {
                executed = true
            }

            assertTrue(executed)
            assertEquals(0, failures)
        }

    @Test
    fun `invokes onFailure and continues when block throws an exception`() =
        runTest {
            val failure = IllegalStateException("boom")
            var observed: Exception? = null
            var calls = 0

            runOrHandle(
                onFailure = {
                    observed = it
                    calls++
                }
            ) { throw failure }

            assertSame(failure, observed)
            assertEquals(1, calls)
        }

    @Test
    fun `rethrows the original CancellationException`() =
        runTest {
            val cancellation = CancellationException("cancelled")

            val thrown = assertFailsWith<CancellationException> {
                runOrHandle(onFailure = { }) { throw cancellation }
            }

            assertSame(cancellation, thrown)
        }

    @Test
    fun `invokes onCancellation but not onFailure before rethrowing`() =
        runTest {
            val cancellation = CancellationException("cancelled")
            var observed: CancellationException? = null
            var failures = 0
            var cancellations = 0

            val thrown = assertFailsWith<CancellationException> {
                runOrHandle(
                    onFailure = { failures++ },
                    onCancellation = {
                        observed = it
                        cancellations++
                    }
                ) { throw cancellation }
            }

            assertSame(cancellation, observed)
            assertSame(cancellation, thrown)
            assertEquals(0, failures)
            assertEquals(1, cancellations)
        }

    @Test
    fun `does not invoke onCancellation for ordinary failures`() =
        runTest {
            var cancelled = false
            var handled = false

            runOrHandle(
                onFailure = { handled = true },
                onCancellation = { cancelled = true }
            ) { throw IllegalStateException("boom") }

            assertTrue(handled)
            assertFalse(cancelled)
        }

    @Test
    fun `propagates exceptions thrown by onFailure`() =
        runTest {
            val callbackFailure = IllegalArgumentException("handler failed")

            val thrown = assertFailsWith<IllegalArgumentException> {
                runOrHandle(onFailure = { throw callbackFailure }) {
                    throw IllegalStateException("boom")
                }
            }

            assertSame(callbackFailure, thrown)
        }

    @Test
    fun `preserves cancellation if onCancellation throws`() =
        runTest {
            val cancellation = CancellationException("cancelled")
            val callbackFailure = IllegalStateException("callback failed")

            val thrown = assertFailsWith<CancellationException> {
                runOrHandle(
                    onFailure = { },
                    onCancellation = { throw callbackFailure }
                ) { throw cancellation }
            }

            assertSame(cancellation, thrown)
            assertEquals(1, thrown.suppressedExceptions.size)
            assertSame(callbackFailure, thrown.suppressedExceptions.single())
        }

    @Test
    fun `propagates Throwable that is not an Exception`() =
        runTest {
            val fatal = Throwable("fatal")
            var handled = false

            val thrown = assertFailsWith<Throwable> {
                runOrHandle(onFailure = { handled = true }) { throw fatal }
            }

            assertSame(fatal, thrown)
            assertFalse(handled)
        }
}
