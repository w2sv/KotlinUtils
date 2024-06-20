@file:Suppress("unused")

package com.w2sv.kotlinutils.generic

inline fun <reified T : Enum<T>> enumEntryByOrdinal(ordinal: Int): T =
    enumValues<T>()[ordinal]