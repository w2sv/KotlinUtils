@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines.flow

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @return the [Flow.first] value in a synchronous manner by blocking the current thread.
 *
 * @see Flow.first
 * @see runBlocking
 */
fun <T> Flow<T>.firstBlocking(): T =
    runBlocking { first() }

/**
 * Convert the [Flow] to a [StateFlow], whose initial value will be the [Flow.first] value.
 * Use with caution: the [Flow.first] value will be procured synchronously by blocking the current thread.
 *
 * @see stateIn
 * @see runBlocking
 */
fun <T> Flow<T>.stateInWithBlockingInitial(scope: CoroutineScope, started: SharingStarted = SharingStarted.Eagerly): StateFlow<T> =
    stateIn(scope = scope, started = started, initialValue = firstBlocking())

/**
 * A shorthand for calling [Flow.collect] with the passed [collector] on the passed [scope].
 */
fun <T> Flow<T>.collectOn(
    scope: CoroutineScope,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    collector: FlowCollector<T>
) {
    scope.launch(context, start) {
        collect(collector)
    }
}

/**
 * A shorthand for calling [Flow.collectLatest] with the passed [action] on the passed [scope].
 */
fun <T> Flow<T>.collectLatestOn(
    scope: CoroutineScope,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    action: suspend (value: T) -> Unit
) {
    scope.launch(context, start) {
        collectLatest(action)
    }
}
