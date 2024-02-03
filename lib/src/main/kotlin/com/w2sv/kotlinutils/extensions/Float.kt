@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

fun Float.rounded(nDecimalPlaces: Int): String =
    "%.${nDecimalPlaces}f".format(this)