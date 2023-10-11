package com.alextfos.beer.ui.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.alextfos.punkoo.common.ui.components.error.ErrorView

@Composable
fun BeerDetailScreen(
    viewModel: BeerDetailViewModel = hiltViewModel()
) {
    viewModel.beer?.let { beer ->
        BeerDetailDrawer(beer)
    } ?: run {
        ErrorView()
    }

}
