@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.Job

inline fun Job?.invokeOnCompletion(crossinline block: () -> Unit): DisposableHandle? =
    if (this != null) {
        invokeOnCompletion {
            block()
        }
    } else {
        block()
        null
    }

/**
 * Cancels the job with the passed [cause] if it is active.
 *
 * @return `true` if the job was active and therefore cancelled, `false` otherwise.
 */
fun Job.cancelIfActive(cause: CancellationException? = null): Boolean {
    if (isActive) {
        cancel(cause)
        return true
    }
    return false
}
