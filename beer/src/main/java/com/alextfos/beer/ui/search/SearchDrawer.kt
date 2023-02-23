package com.alextfos.beer.ui.search

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.alextfos.punkoo.styles.ui.theme.Theme

@Composable
fun SearchDrawer(
    viewModel: SearchViewModel = hiltViewModel()
) {
    var flow = viewModel.getPagedSearch()

    Scaffold(
        backgroundColor = Theme.colors.background,

        topBar = {
            TopAppBar(
                elevation = Theme.objectStyle.elevation,
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
    ) {
        SearchPagedList(
            flow
        )
    }
}