@file:Suppress("unused")

package com.w2sv.kotlinutils

fun <K> Map<K, Boolean>.filterTrueKeys(): Set<K> =
    keys.filterToSet { getValue(it) }

fun <K> MutableMap<K, Boolean>.toggle(key: K) {
    put(key, !getValue(key))
}

/**
 * Maps the entries of this [Map] using [transform] and returns the thereby created Map. Does not modify the original Map.
 */
inline fun <K, V, RK, RV> Map<K, V>.map(transform: (Map.Entry<K, V>) -> Pair<RK, RV>): Map<RK, RV> =
    entries.associate(transform)

/**
 * @return a copy of this [Map] transformed through [transform].
 */
inline fun <K, V> Map<K, V>.copy(transform: MutableMap<K, V>.() -> Unit): Map<K, V> =
    toMutableMap().apply(transform)

/**
 * Updates the value corresponding to [k] by applying [transform] to it and returns the resulting [Map] for method chaining.
 */
inline fun <K, V> MutableMap<K, V>.update(k: K, transform: (V) -> V): Map<K, V> =
    apply { this[k] = transform(getValue(k)) }
