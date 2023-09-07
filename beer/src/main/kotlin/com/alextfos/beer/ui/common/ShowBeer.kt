package com.alextfos.beer.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.alextfos.beer.domain.SampleBeerBuilder
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.styles.ui.theme.Theme

@Composable
fun ShowBeer(beer: BeerBo) {
    Row {
        AsyncImage(
            model = beer.imageUrl,
            contentDescription = null
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = Theme.typography.text,
            color = Theme.colors.text,
            text = beer.name
        )
    }
}

@Preview
@Composable
fun SearchItemPreview() {
    ShowBeer(SampleBeerBuilder().buildSingle())
}
