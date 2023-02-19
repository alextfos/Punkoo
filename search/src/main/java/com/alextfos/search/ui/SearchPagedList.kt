package com.alextfos.search.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.alextfos.punkoo.common.ui.components.error.ErrorView
import com.alextfos.search.domain.entity.BeerBo
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

@Composable
fun SearchPagedList(pagedSearch: Flow<PagingData<BeerBo>>) {

    val searchList = pagedSearch.collectAsLazyPagingItems()

    if (searchList.itemCount == 0 && searchList.loadState.append.endOfPaginationReached) {
        ErrorView()
    } else {
        LazyColumn {
            items(searchList.itemCount) { index ->
                SearchItem(
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
                        Timber.e("")
                    }
                }
            }
        }
    }
}