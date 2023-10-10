package com.alextfos.beer.ui.common

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alextfos.beer.domain.SampleBeerBuilder
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.common.R

@Composable
fun ShowBeer(beer: BeerBo) {
    Box(
        modifier = Modifier
            .height(160.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.tertiary)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = beer.name
                )
                Spacer(Modifier.width(120.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = beer.tagLine
                )
            }
        }
        AsyncImage(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.TopCenter)
                .size(120.dp),
            model = beer.imageUrl,
            placeholder = painterResource(id = R.drawable.beer),
            contentDescription = null
        )
    }

}

@Preview
@Composable
fun SearchItemPreview() {
    ShowBeer(
        SampleBeerBuilder()
            .withName("Long nameeee nameee nameeee")
            .withTagLine("Super beeeeer beeeer beeeeeer")
            .buildSingle()
    )
}
