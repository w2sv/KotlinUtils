@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

val Boolean.asInt: Int
    get() = if (equals(true)) 1 else 0

val Boolean.asSignedInt: Int
    get() = if (equals(true)) 1 else -1
