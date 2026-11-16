package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.cancellation.CancellationException

/**
 * Invokes [onCancellation] and rethrows the original cancellation [exception].
 *
 * Exceptions thrown by the callback are attached as suppressed exceptions
 * rather than replacing the original cancellation.
 */
@PublishedApi
internal inline fun rethrowCancellation(exception: CancellationException, onCancellation: (CancellationException) -> Unit): Nothing {
    try {
        onCancellation(exception)
    } catch (callbackException: Throwable) {
        if (callbackException !== exception) {
            exception.addSuppressed(callbackException)
        }
    }

    throw exception
}
