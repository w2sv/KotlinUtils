package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException

/**
 * Executes the given suspending [block] and wraps its result in a [Result].
 *
 * Unlike [runCatching], this function does **not** catch [CancellationException],
 * preserving proper coroutine cancellation semantics.
 */
suspend inline fun <T> runCatchingCancellable(crossinline block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: Throwable) {
        if (e is CancellationException) throw e
        Result.failure(e)
    }
