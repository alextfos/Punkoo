package com.alextfos.punkoo.common.ext

import junit.framework.TestCase.assertEquals
import org.junit.Test

class StringExtTests {
    @Test
    fun testTest() {
        assertEquals(
            "beer_ipa",
            listOf("beer", "ipa").normalizeWithUnderScores()
        )
    }
}
