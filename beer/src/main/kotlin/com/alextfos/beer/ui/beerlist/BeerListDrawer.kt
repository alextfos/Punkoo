package com.alextfos.beer.ui.beerlist

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.alextfos.beer.ui.search.ShowBeerList

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
