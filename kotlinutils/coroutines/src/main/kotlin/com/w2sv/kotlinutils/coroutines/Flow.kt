@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking

fun <T> Flow<T>.firstBlocking(): T =
    runBlocking { first() }

fun <T> Flow<T>.stateInWithSynchronousInitial(
    scope: CoroutineScope
): StateFlow<T> =
    stateIn(scope = scope, started = SharingStarted.Eagerly, initialValue = firstBlocking())

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