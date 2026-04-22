package com.w2sv.kotlinutils.coroutines.flow

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.coroutines.flow.MutableStateFlow

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
