@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

fun <T> Iterator<T>.getNextPair(): Pair<T, T> =
    Pair(next(), next())

fun <T> Iterator<T>.getNextTriple(): Triple<T, T, T> =
    Triple(next(), next(), next())