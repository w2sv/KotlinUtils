@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

fun <K, V> Map<K, V>.valueEqualTo(other: Map<K, V>): Boolean =
    all { (k, v) ->
        other.getValue(k) == v
    }