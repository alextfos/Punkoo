package com.alextfos.beer.ui.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.alextfos.punkoo.common.ui.components.error.ErrorView
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.common.ShowBeer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@Composable
fun SearchPagedList(pagedSearch: Flow<PagingData<BeerBo>>) {

    val searchList = pagedSearch.collectAsLazyPagingItems()
    val error = rememberSaveable {
        mutableStateOf(false)
    }

    if ((searchList.itemCount == 0 && searchList.loadState.append.endOfPaginationReached) ||
            error.value) {
        ErrorView()
    } else {
        LazyColumn {
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