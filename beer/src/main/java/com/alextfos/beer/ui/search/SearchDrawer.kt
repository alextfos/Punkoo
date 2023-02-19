package com.alextfos.beer.ui.search

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchDrawer(
    viewModel: SearchViewModel = hiltViewModel()
) {
    Box {
        SearchPagedList(
            viewModel.getPagedSearch()
        )
    }
}