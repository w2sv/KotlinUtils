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

/**
 * Combines three flows into a single flow of triples.
 *
 * Each emission from any of [a], [b], or [c] triggers a new emission of a [Triple] containing
 * the latest values from all three flows.
 */
fun <A, B, C> combineToTriple(
    a: Flow<A>,
    b: Flow<B>,
    c: Flow<C>
): Flow<Triple<A, B, C>> =
    combine(a, b, c, ::Triple)
