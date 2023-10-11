package com.alextfos.beer.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.punkoo.common.navigation.Screen

@Composable
fun BeerDetailScreen(
    viewModel: BeerDetailViewModel = hiltViewModel()
) {
    Text("Detail: ${viewModel.beerId}")
}
