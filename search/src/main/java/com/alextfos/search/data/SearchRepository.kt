package com.alextfos.search.data

import com.alextfos.search.data.api.SearchApi
import com.alextfos.punkoo.common.ext.safeBody
import com.alextfos.punkoo.common.exception.EmptyListException
import com.alextfos.punkoo.common.ext.normalizeWithUnderScores
import com.alextfos.search.data.dto.BeerDto

class SearchRepository(
    private val searchApi: SearchApi,
) {
    suspend fun searchBeer(
        beerTokens: List<String>
    ): List<BeerDto> {
        val result = searchApi.searchBeers(
            beerTokens = beerTokens.normalizeWithUnderScores(),
            page = 1,
            itemsByPage = 10
        ).safeBody()

        if (result.isEmpty()) {
            throw EmptyListException("This result is empty")
        }
        return result
    }

    suspend fun searchRandom(
        beerTokens: List<String>
    ): List<BeerDto> {
        val result = searchApi.getRandomBeerList().safeBody()
        if (result.isEmpty()) {
            throw EmptyListException("This result is empty")
        }
        return result
    }
}
