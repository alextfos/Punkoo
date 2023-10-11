package com.alextfos.beer.ui.beerlist

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.alextfos.beer.ui.common.BeerUi

@Composable
fun BeerListDrawer(
    viewModel: BeerListViewModel = hiltViewModel(),
    onBeerClick: (BeerUi) -> Unit
) {
    ShowBeerList(
        pagedSearch = viewModel.getBeerList()
    ) {
        viewModel.selectBeer(it)
        onBeerClick.invoke(it)
    }
}
