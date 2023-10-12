package com.alextfos.punkoo.common.ext

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StringExtTests {
    @Test
    fun `WHEN map underscores EXPECT normalized with underscores`() {
        val res = listOf("beer", "ipa").normalizeWithUnderScores()
        assertThat(res, `is`("beer_ipa"))
    }
}
