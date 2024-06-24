@file:Suppress("unused")

package com.w2sv.kotlinutils

fun <T> Iterator<T>.nextPair(): Pair<T, T> =
    Pair(next(), next())

fun <T> Iterator<T>.nextTriple(): Triple<T, T, T> =
    Triple(next(), next(), next())