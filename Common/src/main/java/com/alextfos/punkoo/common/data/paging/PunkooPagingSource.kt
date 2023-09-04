package com.alextfos.punkoo.common.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import timber.log.Timber

abstract class PunkooPagingSource<T : Any>(
) : PagingSource<Int, T>() {
    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val currentPageNumber = params.key ?: 1

        return try {
            val list = loadData(currentPageNumber)

            var nextPageNumber: Int? = null
            if (list.isNotEmpty()) {
                nextPageNumber = currentPageNumber + 1
            }
            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (t: Throwable) {
            Timber.d(t)
            return LoadResult.Error(t)
        }
    }

    abstract suspend fun loadData(currentPageNumber: Int): List<T>
}
