@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

val Enum<*>.nonZeroOrdinal: Int
    get() = ordinal + 1

inline fun <reified T: Enum<T>> getByOrdinal(ordinal: Int): T =
    enumValues<T>()[ordinal]