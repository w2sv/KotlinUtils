@file:Suppress("unused")

package com.w2sv.kotlinutils.generic

fun Float.rounded(decimalPlaces: Int): String =
    "%.${decimalPlaces}f".format(this)