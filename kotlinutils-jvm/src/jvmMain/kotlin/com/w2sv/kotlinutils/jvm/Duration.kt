@file:Suppress("unused")

package com.w2sv.kotlinutils.jvm

import java.time.Duration

fun Duration.toSecondsCompat(): Long =
    seconds % 60
