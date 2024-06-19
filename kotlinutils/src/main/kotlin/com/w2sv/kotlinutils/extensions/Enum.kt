@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

inline fun <reified T : Enum<T>> getEnumByOrdinal(ordinal: Int): T =
    enumValues<T>()[ordinal]