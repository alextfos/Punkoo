package com.alextfos.search.data

import com.alextfos.punkoo.common.data.paging.PunkooPagingSource
import com.alextfos.punkoo.common.ext.normalizeWithUnderScores
import com.alextfos.punkoo.common.ext.safeBody
import com.alextfos.search.data.api.SearchApi
import com.alextfos.search.data.dto.BeerDto


class SearchPagingSource(
    private val pageSize: Int,
    private val searchTokenList: List<String>,
    private val searchApi: SearchApi
) : PunkooPagingSource<BeerDto>() {

    override suspend fun loadData(currentPageNumber: Int): List<BeerDto> {

        return searchApi.searchBeers(
            beerTokens = searchTokenList.normalizeWithUnderScores(),
            pageSize = pageSize,
            page = currentPageNumber
        ).safeBody()
    }
}
