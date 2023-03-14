@file:Suppress("unused")

package com.w2sv.kotlinutils.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * [Boolean] delegate, automatically inverting its value upon calling its getter
 * if [value]==[switchOn]
 */
class AutoSwitch(var value: Boolean, private val switchOn: Boolean) :
    ReadWriteProperty<Any?, Boolean> {

    fun getValueWithSwitch(): Boolean =
        value
            .also {
                if (it == switchOn)
                    value = !it
            }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean =
        getValueWithSwitch()

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        this.value = value
    }

    /**
     * Combines the [AutoSwitch] functionality with the one of a map delegate
     */
    class Mapped(
        private val map: MutableMap<String, Boolean>,
        private val switchOn: Boolean
    ) : ReadWriteProperty<Any?, Boolean> {

        fun getValueWithSwitch(key: String): Boolean =
            map.getValue(key)
                .also {
                    if (it == switchOn)
                        map[key] = !it
                }

        override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean =
            getValueWithSwitch(property.name)

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
            map[property.name] = value
        }
    }
}