package com.alextfos.beer.ui.common

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.alextfos.beer.ui.SampleBeerUiBuilder
import org.junit.Rule
import org.junit.Test

class ShowBeerTest {
    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testElementIsClickable() {
        rule.setContent {
            ShowBeer(beer = SampleBeerUiBuilder().buildSingle()) {}
        }

        rule.onNode(hasTestTag(TAG)).assertHasClickAction()
    }
}
