@file:Suppress("unused")

package com.w2sv.kotlinutils

/**
 * Returns the enum entry of type [T] with the given ordinal.
 *
 * @param ordinal The ordinal of the enum entry. Must therefore be non-negative.
 */
inline fun <reified T : Enum<T>> enumEntryByOrdinal(ordinal: Int): T =
    try {
        enumValues<T>()[ordinal]
    } catch (e: IndexOutOfBoundsException) {
        throw IllegalArgumentException("Ordinal $ordinal is out of bounds for enum ${T::class.java.simpleName}.")
    }