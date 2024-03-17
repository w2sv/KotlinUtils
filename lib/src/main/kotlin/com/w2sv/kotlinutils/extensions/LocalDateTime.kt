package com.w2sv.kotlinutils.extensions

import android.annotation.TargetApi
import android.os.Build
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.WeekFields
import java.util.Locale

@TargetApi(Build.VERSION_CODES.O)
fun LocalDateTime.weekOfYear(locale: Locale = Locale.getDefault()): Int =
    get(WeekFields.of(locale).weekOfYear())

@TargetApi(Build.VERSION_CODES.O)
fun LocalDateTime.timeDeltaUntilNow(): Duration =
    durationBetween(LocalDateTime.now())

@TargetApi(Build.VERSION_CODES.O)
fun LocalDateTime.durationBetween(other: LocalDateTime): Duration =
    Duration.between(
        this, other
    )