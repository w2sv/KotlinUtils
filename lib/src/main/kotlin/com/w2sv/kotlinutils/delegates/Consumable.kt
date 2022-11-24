@file:Suppress("unused")

package com.w2sv.kotlinutils.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegate of objects, the value of which is to be retrieved exactly once.
 * After getting (==consuming) its value, it will be automatically set to null
 */
class Consumable<T>(var value: T? = null) : ReadWriteProperty<Any, T?> {

    fun consume(): T? =
        value
            .also { value = null }

    override fun getValue(thisRef: Any, property: KProperty<*>): T? =
        consume()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        this.value = value
    }
}