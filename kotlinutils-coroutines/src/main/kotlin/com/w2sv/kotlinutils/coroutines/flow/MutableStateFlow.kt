@file:Suppress("unused")

package com.w2sv.kotlinutils.coroutines.flow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

/**
 * Toggles the [MutableStateFlow.value] in an atomic manner by using [update] if it is not `null`.
 */
fun MutableStateFlow<Boolean?>.toggle() {
    update { it?.not() }
}
