package com.alextfos.beer.ui.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.common.ShowBeer
import com.alextfos.punkoo.common.ui.components.error.ErrorView
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchPagedList(
    modifier: Modifier = Modifier,
    pagedSearch: Flow<PagingData<BeerBo>>
) {

    val searchList = pagedSearch.collectAsLazyPagingItems()
    val error = rememberSaveable {
        mutableStateOf(false)
    }

    if ((searchList.itemCount == 0 && searchList.loadState.append.endOfPaginationReached) ||
            error.value) {
        ErrorView()
    } else {
        LazyColumn(modifier = modifier) {
            items(searchList.itemCount) { index ->
                ShowBeer(
                    beer = searchList[index]!!
                )
            }

            searchList.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        //Modifier to manage load state when first time response page is loading
                    }
                    loadState.append is LoadState.Loading -> {
                        //Modifier to manage load state when next response page is loading
                    }
                    loadState.append is LoadState.Error -> {
                        error.value = true
                    }
                }
            }
        }
    }
}