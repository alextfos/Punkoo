package com.alextfos.beer.ui.beerlist

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BeerListDrawer(
    viewModel: BeerListViewModel = hiltViewModel(),
    onBeerClick: (Int) -> Unit
) {
    ShowBeerList(
        pagedSearch = viewModel.getBeerList(),
        onBeerClick = onBeerClick
    )
}
