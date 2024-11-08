package com.w2sv.kotlinutils.time

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneId

class LocalDateTimeKtTest {

    @Test
    fun testDurationBetween() {
        val dateTime1 = LocalDateTime.of(2023, 1, 1, 12, 0)
        val dateTime2 = LocalDateTime.of(2023, 1, 1, 12, 0, 5)
        val difference = dateTime1.durationBetween(dateTime2).toMillis()

        assertEquals(5000, difference)
    }

    @Test
    fun testLocalDateTimeFromSecondsUnixTimeStamp() {
        assertEquals(
            LocalDateTime.of(2023, 11, 3, 20, 54, 44),
            localDateTimeFromSecondsUnixTimestamp(1699041284L, ZoneId.of("Europe/Berlin"))
        )
    }
}