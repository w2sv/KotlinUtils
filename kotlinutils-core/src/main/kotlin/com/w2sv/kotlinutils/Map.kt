@file:Suppress("unused")

package com.w2sv.kotlinutils

fun <K> Map<K, Boolean>.filterTrueKeys(): Set<K> =
    keys.filter { getValue(it) }

fun <K> MutableMap<K, Boolean>.toggle(key: K) {
    put(key, !getValue(key))
}

/**
 * Updates the value corresponding to [k] by applying [transform] to it.
 */
inline fun <K, V> MutableMap<K, V>.update(k: K, transform: (V) -> V) {
    put(k, transform(getValue(k)))
}
