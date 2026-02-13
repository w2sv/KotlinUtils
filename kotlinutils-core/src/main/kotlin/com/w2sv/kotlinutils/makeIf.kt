package com.w2sv.kotlinutils

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Executes [block] and returns its result only if [condition] is true,
 * otherwise returns null.
 *
 * Unlike [kotlin.takeIf], this function evaluates the condition *before*
 * creating the value. This makes it useful when the value is expensive to
 * compute or has side effects and should only be created conditionally.
 */
@OptIn(ExperimentalContracts::class)
inline fun <T> makeIf(condition: Boolean, block: () -> T): T? {
    contract {
        returnsNotNull() implies condition
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    return if (condition) block() else null
}
