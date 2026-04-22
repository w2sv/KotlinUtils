package com.w2sv.kotlinutils

fun <K> Map<K, Boolean>.trueKeys(): List<K> =
    keysWhere { it }

fun <K> Map<K, Boolean>.trueKeysSet(): Set<K> =
    keysWhereToSet { it }

fun <K> MutableMap<K, Boolean>.toggle(key: K) {
    put(key, !getValue(key))
}
