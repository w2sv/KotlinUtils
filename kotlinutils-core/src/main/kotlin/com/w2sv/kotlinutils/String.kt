@file:Suppress("unused")

package com.w2sv.kotlinutils

import java.util.Locale

/**
 * [reference](https://stackoverflow.com/a/67843987/12083276)
 */
fun String.capitalize(locale: Locale = Locale.getDefault()): String =
    replaceFirstChar {
        if (it.isLowerCase()) {
            it.titlecase(locale)
        } else {
            it.toString()
        }
    }
