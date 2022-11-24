@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

val Enum<*>.nonZeroOrdinal: Int get() =  // TODO: come up with better name
    ordinal + 1