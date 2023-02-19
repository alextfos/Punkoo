package com.alextfos.beer.data

import com.alextfos.punkoo.common.data.paging.PunkooPagingSource
import com.alextfos.punkoo.common.ext.normalizeWithUnderScores
import com.alextfos.punkoo.common.ext.safeBody
import com.alextfos.beer.data.api.BeerApi
import com.alextfos.beer.data.dto.BeerDto


class SearchPagingSource(
    private val pageSize: Int,
    private val searchTokenList: List<String>,
    private val beerApi: BeerApi
) : PunkooPagingSource<BeerDto>() {

    override suspend fun loadData(currentPageNumber: Int): List<BeerDto> {

        return beerApi.searchBeers(
            beerTokens = searchTokenList.normalizeWithUnderScores(),
            pageSize = pageSize,
            page = currentPageNumber
        ).safeBody()
    }
}
