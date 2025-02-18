package com.w2sv.kotlinutils

/**
 * @return a thread unsafe, [Lazy]-wrapped object, using [LazyThreadSafetyMode.NONE].
 * This results in no thread lock being acquired when initializing the lazy wrapper, which improves performance.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <T> threadUnsafeLazy(noinline initializer: () -> T): Lazy<T> =
    lazy(mode = LazyThreadSafetyMode.NONE, initializer)
