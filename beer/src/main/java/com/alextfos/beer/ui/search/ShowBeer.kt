package com.alextfos.beer.ui.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.sampleBeerBo
import com.alextfos.punkoo.styles.ui.theme.Theme

@Composable
fun ShowBeer(beer: BeerBo) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        style = Theme.typography.text,
        color = Theme.colors.text,
        text = beer.name
    )
}

@Preview
@Composable
fun SearchItemPreview() {
    ShowBeer(sampleBeerBo())
}
