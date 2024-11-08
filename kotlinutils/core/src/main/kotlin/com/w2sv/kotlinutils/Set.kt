@file:Suppress("unused")

package com.w2sv.kotlinutils

/**
 * Returns a new [Set] containing all elements from this [Set] that satisfy the given [predicate].
 *
 * The stdlib [Iterable.filter] extension function on the contrary only returns a List.
 */
inline fun <T> Set<T>.filter(predicate: (T) -> Boolean): Set<T> =
    filterTo(mutableSetOf(), predicate)

/**
 * Returns a new [Set] containing all elements from this [Set] that don't satisfy the given [predicate].
 *
 * The stdlib [Iterable.filterNot] extension function on the contrary only returns a List.
 */
inline fun <T> Set<T>.filterNot(predicate: (T) -> Boolean): Set<T> =
    filterNotTo(mutableSetOf(), predicate)
