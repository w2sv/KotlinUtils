package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException

/**
 * Executes [block], invoking [onFailure] if it throws an [Exception].
 *
 * Non-cancellation exceptions are handled without being rethrown, allowing
 * execution to continue normally after [onFailure] returns.
 *
 * Coroutine cancellation is always propagated. When cancellation occurs,
 * [onCancellation] is invoked before rethrowing [kotlin.coroutines.cancellation.CancellationException].
 * If the callback itself throws, its exception is suppressed onto the
 * original cancellation exception.
 *
 * Other [Throwable] types, such as fatal JVM errors, propagate unchanged.
 * Exceptions thrown by [onFailure] are also propagated.
 *
 * @param onFailure Callback invoked when [block] fails with a non-cancellation exception.
 * @param onCancellation Optional callback invoked when [block] is canceled.
 * @param block Suspending operation to execute.
 */
suspend inline fun runOrHandle(
    onFailure: (Exception) -> Unit,
    onCancellation: (CancellationException) -> Unit = {},
    block: suspend () -> Unit
) {
    try {
        block()
    } catch (exception: CancellationException) {
        rethrowCancellation(exception, onCancellation)
    } catch (exception: Exception) {
        onFailure(exception)
    }
}
