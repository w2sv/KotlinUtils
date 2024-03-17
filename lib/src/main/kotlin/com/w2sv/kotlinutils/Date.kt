@file:Suppress("unused")

package com.w2sv.kotlinutils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun dateTimeNow(pattern: String = "yyyyMMdd_HHmmss", locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(pattern, locale)
        .format(Date())

fun dateFromUnixTimestamp(unixTimestamp: String): Date =
    Date(unixTimestamp.toLong() * 1000)

fun timeDelta(a: Date, b: Date, timeUnit: TimeUnit): Long =
    timeUnit.convert(
        a.time - b.time,
        TimeUnit.MILLISECONDS
    )

fun timeDeltaFromNow(date: Date, timeUnit: TimeUnit): Long =
    timeDelta(date, Date(System.currentTimeMillis()), timeUnit)
