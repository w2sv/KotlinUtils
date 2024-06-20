@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines

import kotlinx.coroutines.flow.MutableStateFlow

fun MutableStateFlow<Boolean>.toggle() {
    value = !value
}