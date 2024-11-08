@file:Suppress("unused")

package com.w2sv.kotlinutils.time

import java.time.Duration

fun Duration.toSecondsCompat(): Long =
    seconds % 60