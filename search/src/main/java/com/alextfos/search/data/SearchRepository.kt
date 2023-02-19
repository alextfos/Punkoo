package com.alextfos.search.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alextfos.punkoo.common.exception.EmptyListException
import com.alextfos.punkoo.common.ext.safeBody
import com.alextfos.search.data.api.SearchApi
import com.alextfos.search.data.dto.BeerDto
import kotlinx.coroutines.flow.Flow

class SearchRepository(
    private val searchApi: SearchApi,
) {
    val pageSize = 10
    val prefetchPercent = 1.5

    suspend fun getRandomBeer(): List<BeerDto> {
        val res = searchApi.getRandomBeer().safeBody()

        if (res.isEmpty()) {
            throw EmptyListException("Random beer empty")
        }

        return res
    }
    fun searchBeer(
        beerTokens: List<String>
    ): Flow<PagingData<BeerDto>> {
        return Pager(
            PagingConfig(pageSize = pageSize, prefetchDistance = (pageSize * prefetchPercent).toInt())
        ) {
            SearchPagingSource(
                pageSize = pageSize,
                searchTokenList = beerTokens,
                searchApi = searchApi
            )
        }.flow
    }
}
