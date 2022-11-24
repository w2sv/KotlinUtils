@file:Suppress("unused")

package com.w2sv.kotlinutils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun dateTimeNow(pattern: String = "yyyyMMdd_HHmmss", locale: Locale = Locale.ENGLISH): String =
    SimpleDateFormat(pattern, locale)
        .format(Date())

fun timeDelta(earlier: Date, later: Date, timeUnit: TimeUnit): Long =
    timeUnit.convert(
        later.time - earlier.time,
        TimeUnit.MILLISECONDS
    )

fun dateFromUnixTimestamp(unixTimestamp: String): Date =
    Date(unixTimestamp.toLong() * 1000)