package com.w2sv.kotlinutils.coroutines.flow

import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class MutableStateFlowKtTest {

    @Test
    fun testToggle() {
        val flow = MutableStateFlow(true)

        flow.toggle()
        assertFalse(flow.value)

        flow.toggle()
        assertTrue(flow.value)
    }

    @Test
    fun testToggleIfNotNull() {
        val flow = MutableStateFlow<Boolean?>(null)

        flow.toggleIfNotNull()
        assertNull(flow.value)

        flow.value = true
        flow.toggleIfNotNull()
        assertEquals(false, flow.value)
    }
}
