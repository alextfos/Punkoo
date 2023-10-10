package com.alextfos.beer.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.alextfos.punkoo.styles.ui.theme.Theme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchDrawer(
    viewModel: SearchViewModel = hiltViewModel()
) {
    var flow = viewModel.getPagedSearch()

    Scaffold(
        //backgroundColor = Theme.colors.background,
        topBar = {
            TopAppBar(
                //elevation = Theme.objectStyle.elevation,
                title = {
                    ShowSearchBar(viewModel) {
                        flow = viewModel.getPagedSearch()
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            modifier = Modifier,
                            contentDescription = "Text"
                        )
                    }
            }
            )
        }
    ) { padding ->
        ShowBeerList(
            modifier = Modifier.padding(padding),
            pagedSearch = flow
        )
    }
}