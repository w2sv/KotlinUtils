package com.w2sv.kotlinutils.coroutines.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

/**
 * Combines two flows into a single flow of pairs.
 *
 * Each emission from either [a] or [b] triggers a new emission of a [Pair] containing
 * the latest values from both flows.
 */
fun <A, B> combineToPair(a: Flow<A>, b: Flow<B>): Flow<Pair<A, B>> =
    combine(a, b, ::Pair)
