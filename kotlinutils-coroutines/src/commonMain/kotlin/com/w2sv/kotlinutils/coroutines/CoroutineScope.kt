@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Launches [block] after [timeMillis] milliseconds.
 * @deprecated Use the [Duration]-based overload instead.
 */
@Deprecated(
    message = "Use the overload accepting a Duration.",
    replaceWith = ReplaceWith(
        expression = "launchDelayed(timeMillis.milliseconds, context, start, block)",
        imports = ["kotlin.time.Duration.Companion.milliseconds"]
    )
)
fun CoroutineScope.launchDelayed(
    timeMillis: Long,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job =
    launchDelayed(timeMillis.milliseconds, context, start, block)

/**
 * Launches the [block] coroutine after a delay of [delayFor].
 */
fun CoroutineScope.launchDelayed(
    delayFor: Duration,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job =
    launch(context, start) {
        delay(delayFor)
        block()
    }

/**
 * A shorthand for [CoroutineScope].launch { [flow].collect([flowCollector]) }
 */
fun <T> CoroutineScope.collectFromFlow(
    flow: Flow<T>,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    flowCollector: FlowCollector<T>
): Job =
    launch(context, start) {
        flow.collect(flowCollector)
    }

/**
 * A shorthand for [CoroutineScope].launch { [Flow.collectLatest] ([block]) }
 */
fun <T> CoroutineScope.collectLatestFromFlow(
    flow: Flow<T>,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend (value: T) -> Unit
): Job =
    launch(context, start) {
        flow.collectLatest(block)
    }
