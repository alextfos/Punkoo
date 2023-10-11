package com.alextfos.beer.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alextfos.beer.domain.SampleBeerBuilder
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType


@Composable
fun BeerDetailDrawer(beer: BeerBo) {

}

@Preview
@Composable
fun BeerDetailPreviewLight() {
    PunkooTheme(ThemeType.LIGHT) {
        BeerDetailDrawer(
            SampleBeerBuilder()
            .withName("Long nameeee nameee nameeee")
            .withTagLine("Super beeeeer beeeer beeeeeer")
            .buildSingle()
        )
    }
}

@Preview
@Composable
fun BeerDetailPreviewDark() {
    PunkooTheme(ThemeType.DARK) {
        BeerDetailDrawer(
            SampleBeerBuilder()
                .withName("Long nameeee nameee nameeee")
                .withTagLine("Super beeeeer beeeer beeeeeer")
                .buildSingle()
        )
    }
}