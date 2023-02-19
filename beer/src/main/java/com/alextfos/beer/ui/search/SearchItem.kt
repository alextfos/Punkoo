package com.alextfos.beer.ui.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.sampleBeerBo

@Composable
fun SearchItem(beer: BeerBo) {
    Text(
        text = beer.id.toString()
    )
}

@Preview
@Composable
fun SearchItemPreview() {
    SearchItem(sampleBeerBo())
}
