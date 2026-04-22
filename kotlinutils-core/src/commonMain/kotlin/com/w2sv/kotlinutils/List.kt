package com.w2sv.kotlinutils

/**
 * @return a new [List] containing all the elements of this list except for the last one, which will be replaced by [replacement]
 * Will do nothing if this list is empty.
 */
fun <T> List<T>.copyWithReplacedLast(replacement: T): List<T> =
    copy {
        try {
            this[lastIndex] = replacement
        } catch (_: IndexOutOfBoundsException) {}
    }

/**
 * @return a new [List] whose content has been updated by applying [update].
 */
fun <T> List<T>.copy(update: MutableList<T>.() -> Unit): List<T> =
    toMutableList().apply { update() }
