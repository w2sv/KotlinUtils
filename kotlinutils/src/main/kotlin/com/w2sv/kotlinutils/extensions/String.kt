@file:Suppress("unused")

package com.w2sv.kotlinutils.extensions

import java.util.Locale

/**
 * @see
 * https://stackoverflow.com/a/67843987/12083276
 */
fun String.capitalize(): String =
    replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else
            it.toString()
    }