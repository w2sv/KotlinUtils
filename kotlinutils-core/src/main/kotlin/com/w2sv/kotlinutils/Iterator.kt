@file:Suppress("unused")

package com.w2sv.kotlinutils

/**
 * @return a [Pair] containing the next two elements.
 * @throws NoSuchElementException if there are fewer than two elements remaining in the iterator.
 */
fun <T> Iterator<T>.nextPair(): Pair<T, T> =
    Pair(next(), next())

/**
 * @return a [Triple] containing the next three elements.
 * @throws NoSuchElementException if there are fewer than three elements remaining in the iterator.
 */
fun <T> Iterator<T>.nextTriple(): Triple<T, T, T> =
    Triple(next(), next(), next())
