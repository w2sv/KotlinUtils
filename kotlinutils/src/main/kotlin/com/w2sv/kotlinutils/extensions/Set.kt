package com.w2sv.kotlinutils.extensions

inline fun <T> Set<T>.filter(predicate: (T) -> Boolean): Set<T> =
    filterTo(mutableSetOf(), predicate)