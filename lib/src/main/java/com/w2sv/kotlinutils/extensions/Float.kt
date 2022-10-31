package com.w2sv.kotlinutils.extensions

import java.util.Locale

fun Float.rounded(nDecimalPlaces: Int): String =
    "%.${nDecimalPlaces}f".format(this, Locale.ENGLISH)