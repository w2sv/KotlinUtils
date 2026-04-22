@file:Suppress("unused")

package com.w2sv.kotlinutils

/**
 * Returns a list of keys whose values satisfy the given [predicate].
 *
 * The order of keys in the returned list matches the iteration order of [Map.keys].
 *
 * @param predicate a function to test each value.
 * @return a [List] of keys whose corresponding values match [predicate].
 */
fun <K, V> Map<K, V>.keysWhere(predicate: (V) -> Boolean): List<K> =
    keys.filter { predicate(getValue(it)) }

/**
 * Returns a set of keys whose values satisfy the given [predicate].
 *
 * Each key appears only once in the returned set. The order is not guaranteed.
 *
 * @param predicate a function to test each value.
 * @return a [Set] of keys whose corresponding values match [predicate].
 */
fun <K, V> Map<K, V>.keysWhereToSet(predicate: (V) -> Boolean): Set<K> =
    keys.filterToSet { predicate(getValue(it)) }

/**
 * Maps the entries of this [Map] using [transform] and returns the thereby created Map. Does not modify the original Map.
 */
inline fun <K, V, RK, RV> Map<K, V>.map(transform: (Map.Entry<K, V>) -> Pair<RK, RV>): Map<RK, RV> =
    entries.associate(transform)

/**
 * @return a copy of this [Map] transformed through [transform].
 */
inline fun <K, V> Map<K, V>.copy(transform: MutableMap<K, V>.() -> Unit): Map<K, V> =
    toMutableMap().apply(transform)

/**
 * Updates the value corresponding to [key] by applying [transform] to it.
 *
 * __NOTE:__ The current value corresponding to [key] will be retrieved through [getValue], meaning a [NoSuchElementException] will be thrown if [key]
 * is not present in the map.
 *
 * @returns The resulting [Map] for method chaining.
 */
inline fun <K, V> MutableMap<K, V>.update(key: K, transform: (V) -> V): Map<K, V> =
    apply { this[key] = transform(getValue(key)) }

/**
 * If [key] is present in the map and not `null`, updates the value corresponding to it by applying [transform].
 * Otherwise, calls the [defaultValue] function and puts its result into the map under the given [key].
 *
 * @returns The resulting [Map] for method chaining.
 */
inline fun <K, V> MutableMap<K, V>.updateOrPut(
    key: K,
    transform: (V) -> V,
    defaultValue: () -> V
): Map<K, V> =
    apply { this[key] = get(key)?.let { transform(it) } ?: defaultValue() }
