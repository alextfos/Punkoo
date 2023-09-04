package com.alextfos.beer.ui.beerlist

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import arrow.core.left
import com.alextfos.beer.ui.search.SearchPagedList
import com.alextfos.punkoo.common.ui.components.error.ErrorView

@Composable
fun BeerListDrawer(
    viewModel: BeerListViewModel = hiltViewModel()
) {
    SearchPagedList(pagedSearch = viewModel.getBeerList())
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
