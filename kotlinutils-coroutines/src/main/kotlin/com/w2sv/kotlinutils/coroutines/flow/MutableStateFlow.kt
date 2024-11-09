@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines.flow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

fun MutableStateFlow<Boolean>.toggle() {
    update { !it }
}
