@file:Suppress("unused")

package com.w2sv.kotlinutils

/**
 * [reference](https://stackoverflow.com/a/67843987/12083276)
 */
fun String.capitalize(): String =
    replaceFirstChar {
        if (it.isLowerCase()) {
            it.titlecase()
        } else {
            it.toString()
        }
    }
