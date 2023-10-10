package com.alextfos.beer.ui.beerlist

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.alextfos.beer.ui.search.ShowBeerList

@Composable
fun BeerListDrawer(
    viewModel: BeerListViewModel = hiltViewModel()
) {
    ShowBeerList(pagedSearch = viewModel.getBeerList())
    /*
    viewModel.state.beerList.fold(
        ifRight = {
            it?.let { list ->
                SearchPagedList(list)
            }
        }, ifLeft = {
            ErrorView()
        }
    )
    */
}
