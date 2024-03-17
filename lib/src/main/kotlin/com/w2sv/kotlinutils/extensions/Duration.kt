package com.w2sv.kotlinutils.extensions

import android.annotation.TargetApi
import android.os.Build
import java.time.Duration

@TargetApi(Build.VERSION_CODES.O)
fun Duration.getSecondsCompat(): Long =
    seconds % 60