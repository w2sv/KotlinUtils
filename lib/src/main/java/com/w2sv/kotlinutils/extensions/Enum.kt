package com.w2sv.kotlinutils.extensions

val Enum<*>.nonZeroOrdinal: Int get() = ordinal + 1