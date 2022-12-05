@file:Suppress("unused")

package com.w2sv.kotlinutils

fun <T> pairFromIterable(iterable: Iterable<T>): Pair<T, T> =
    iterable.iterator().run {
        Pair(next(), next())
    }

fun <T> tripleFromIterable(iterable: Iterable<T>): Triple<T, T, T> =
    iterable.iterator().run {
        Triple(next(), next(), next())
    }
