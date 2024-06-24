@file:Suppress("unused")

package com.w2sv.kotlinutils

fun <K, V> Map<K, V>.valueEqualTo(other: Map<K, V>): Boolean =
    all { (k, v) ->
        other.getValue(k) == v
    }

fun <K> Map<K, Boolean>.filterTrueKeys(): Set<K> =
    keys.filter { getValue(it) }

fun <K> MutableMap<K, Boolean>.toggle(key: K) {
    put(key, !getValue(key))
}

inline fun <K, V> MutableMap<K, V>.update(k: K, update: (V) -> V) {
    put(k, update(getValue(k)))
}