@file:Suppress("unused")

package com.w2sv.kotlinutils.time

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun dateTimeNow(pattern: String = "yyyyMMdd_HHmmss", locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(pattern, locale)
        .format(Date())

fun dateFromSecondsUnixTimestamp(timestamp: Long): Date =
    Date(timestamp * 1000)

fun timeDeltaBetween(
    a: Date,
    b: Date,
    timeUnit: TimeUnit
): Long =
    timeUnit.convert(
        a.time - b.time,
        TimeUnit.MILLISECONDS
    )

fun timeDeltaToNow(date: Date, timeUnit: TimeUnit): Long =
    timeDeltaBetween(date, Date(System.currentTimeMillis()), timeUnit)
