@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

fun Float.rounded(decimalPlaces: Int): String =
    "%.${decimalPlaces}f".format(this)