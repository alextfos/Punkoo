package com.alextfos.beer.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alextfos.beer.ui.SampleBeerUiBuilder
import com.alextfos.punkoo.common.R
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType
import com.alextfos.punkoo.styles.ui.theme.spacing

const val TAG = "ShowBeer"

@Composable
fun ShowBeer(beer: BeerUi, onBeerClick: (BeerUi)-> Unit) {
    Box(
        modifier = Modifier
            .height(160.dp)
            .testTag(TAG)
            .clickable { onBeerClick(beer) }
    ) {
        ElevatedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(MaterialTheme.spacing.globalPadding)
                .background(Color.Transparent)
                .align(Alignment.BottomCenter),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.globalHalfPadding)
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = beer.name
                )
                Spacer(Modifier.width(120.dp))
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.Transparent),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    maxLines = 2,
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

@Preview(showBackground = true, name = "Dark")
@Composable
fun SearchItemDarkPreview() {
    PunkooTheme(
        ThemeType.DARK
    ) {
        ShowBeer(
            SampleBeerUiBuilder()
                .withName("Long nameeee nameee nameeee")
                .withTagLine("Super beeeeer beeeer beeeeeer")
                .buildSingle()
        ) {}
    }
}

@Preview(showBackground = true, name = "Light")
@Composable
fun SearchItemLightPreview() {
    PunkooTheme(
        ThemeType.LIGHT
    ) {
        ShowBeer(
            SampleBeerUiBuilder()
                .withName("Long nameeee nameee nameeee")
                .withTagLine("Super beeeeer beeeer beeeeeer")
                .buildSingle()
        ) {}
    }
}
