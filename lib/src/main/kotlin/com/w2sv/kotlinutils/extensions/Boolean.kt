@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

fun Boolean.toInt(): Int =
    if (equals(true)) 1 else 0

fun Boolean.toNonZeroInt(): Int =  // TODO: come up with better name
    if (equals(true)) 1 else -1
