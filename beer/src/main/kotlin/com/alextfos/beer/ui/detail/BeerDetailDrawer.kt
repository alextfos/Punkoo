package com.alextfos.beer.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alextfos.beer.domain.SampleBeerBuilder
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.common.R as commonR
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType


@Composable
fun BeerDetailDrawer(beer: BeerBo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            modifier = Modifier
                .background(Color.Transparent)
                .size(120.dp),
            alignment = Alignment.Center,
            model = beer.imageUrl,
            placeholder = painterResource(id = commonR.drawable.beer),
            contentDescription = null
        )
        Text(
            text = beer.name
        )
        Text(
            text = beer.tagLine
        )
        Text(
            text = stringResource(commonR.string.beer_detail_description_title)
        )
        Text(
            text = beer.description
        )
        beer.ibu?.let {
            Text(
                text = stringResource(commonR.string.beer_detail_ibu, String.format("%.1f", it))
            )
        }
        Text(
            text = stringResource(commonR.string.beer_detail_food_pairing_title)
        )
        beer.foodPairing.forEach {
            ShowFoodPairing(it)
        }
        Text(
            text = beer.brewersTips
        )
    }
}



@Preview(showBackground = true)
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

@Preview(showBackground = true)
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