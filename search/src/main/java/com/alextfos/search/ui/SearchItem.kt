package com.alextfos.search.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alextfos.search.domain.entity.BeerBo

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
