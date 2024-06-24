package com.w2sv.kotlinutils

inline fun <T> Set<T>.filter(predicate: (T) -> Boolean): Set<T> =
    filterTo(mutableSetOf(), predicate)