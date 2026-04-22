package com.w2sv.kotlinutils.coroutines.flow

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

fun <T> MutableSharedFlow<T>.emit(
    value: T,
    scope: CoroutineScope,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT
) {
    scope.launch(context, start) {
        emit(value)
    }
}
