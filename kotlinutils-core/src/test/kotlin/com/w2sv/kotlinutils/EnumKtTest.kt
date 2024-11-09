package com.w2sv.kotlinutils

import org.junit.Assert.assertEquals
import org.junit.Test

private enum class RandoEnum { A, B, C }

class EnumKtTest {

    @Test
    fun testEnumEntryByOrdinal() {
        assertEquals(RandoEnum.A, enumEntryByOrdinal<RandoEnum>(0))
        assertEquals(RandoEnum.B, enumEntryByOrdinal<RandoEnum>(1))
        assertEquals(RandoEnum.C, enumEntryByOrdinal<RandoEnum>(2))
    }
}
