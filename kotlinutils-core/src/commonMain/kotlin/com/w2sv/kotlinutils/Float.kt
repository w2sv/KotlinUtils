@file:Suppress("unused")

package com.w2sv.kotlinutils

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.rounded(decimalPlaces: Int): String {
    val factor = 10.0.pow(decimalPlaces)
    val rounded = (this * factor).roundToInt() / factor

    val parts = rounded.toString().split(".")
    val decimals = parts.getOrNull(1)?.padEnd(decimalPlaces, '0') ?: "0".repeat(decimalPlaces)

    return if (decimalPlaces == 0) {
        parts[0]
    } else {
        "${parts[0]}.$decimals"
    }
}
