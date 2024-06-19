package com.w2sv.kotlinutils.time

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.WeekFields
import java.util.Locale

fun localDateTimeFromSecondsUnixTimeStamp(
    secondsTimestamp: Long,
    zoneId: ZoneId = ZoneId.systemDefault()
): LocalDateTime =
    LocalDateTime.ofInstant(
        Instant.ofEpochSecond(secondsTimestamp),
        zoneId
    )

fun localDateTimeFromMilliSecondsUnixTimeStamp(
    msTimeStamp: Long,
    zoneId: ZoneId = ZoneId.systemDefault()
): LocalDateTime =
    LocalDateTime.ofInstant(
        Instant.ofEpochMilli(msTimeStamp),
        zoneId
    )

fun LocalDateTime.weekOfYear(locale: Locale = Locale.getDefault()): Int =
    get(WeekFields.of(locale).weekOfYear())

fun LocalDateTime.durationToNow(): Duration =
    durationBetween(LocalDateTime.now())

fun LocalDateTime.durationBetween(other: LocalDateTime): Duration =
    Duration.between(
        this,
        other
    )