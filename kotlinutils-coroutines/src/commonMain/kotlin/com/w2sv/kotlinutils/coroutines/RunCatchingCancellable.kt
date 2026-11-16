package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException

/**
 * Executes [block] and wraps its outcome in a [Result].
 *
 * Unlike [runCatching], this function preserves coroutine cancellation:
 * [CancellationException] is rethrown rather than captured as a failure.
 *
 * When cancellation occurs, [onCancellation] is invoked before the exception
 * is rethrown. If the callback itself throws, its exception is suppressed
 * onto the original [CancellationException], preserving cancellation.
 *
 * Only [Exception] instances are captured as failures. Other [Throwable]
 * types, such as fatal JVM errors, propagate unchanged.
 *
 * @param onCancellation Optional callback invoked when [block] is cancelled.
 * @param block Suspending operation to execute.
 * @return A [Result] containing either the successful value or the exception.
 */
suspend inline fun <T> runCatchingCancellable(onCancellation: (CancellationException) -> Unit = {}, block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (exception: CancellationException) {
        rethrowCancellation(exception, onCancellation)
    } catch (exception: Exception) {
        Result.failure(exception)
    }
