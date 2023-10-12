package com.alextfos.beer.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType
import com.alextfos.punkoo.styles.ui.theme.spacing


@Composable
fun ShowFoodPairing(food: String) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(MaterialTheme.spacing.globalPadding)
            .background(Color.Transparent),
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
                text = food
            )
        }
    }
}

@Preview
@Composable
fun ShowFoodPairingLight() {
    PunkooTheme(ThemeType.LIGHT) {
        ShowFoodPairing(food = "Test food")
    }
}


@Preview
@Composable
fun ShowFoodPairingDark() {
    PunkooTheme(ThemeType.DARK) {
        ShowFoodPairing(food = "Test food")
    }
}