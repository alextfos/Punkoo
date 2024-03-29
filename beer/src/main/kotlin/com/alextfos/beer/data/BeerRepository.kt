package com.alextfos.beer.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alextfos.beer.data.api.BeerApi
import com.alextfos.beer.data.dto.BeerDto
import kotlinx.coroutines.flow.Flow

class BeerRepository(
    private val beerApi: BeerApi,
) {
    private val pageSize = 25
    private val prefetchPercent = 1.5

    fun getBeerList(
        beerTokens: List<String>? = null
    ): Flow<PagingData<BeerDto>> {
        return Pager(
            PagingConfig(pageSize = pageSize, prefetchDistance = (pageSize * prefetchPercent).toInt())
        ) {
            SearchPagingSource(
                pageSize = pageSize,
                keywordList = beerTokens,
                beerApi = beerApi
            )
        }.flow
    }
}
