package com.alextfos.search.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.alextfos.search.data.SearchRepository
import com.alextfos.search.domain.entity.BeerBo
import com.alextfos.search.domain.mapper.toBeerBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchUseCase(
    private val searchRepository: SearchRepository
) {
    fun invoke(
        searchTokenList: List<String>
    ): Flow<PagingData<BeerBo>> {
        return searchRepository.searchBeer(searchTokenList).map {
            it.map { beerDto ->
                beerDto.toBeerBo()
            }
        }
    }
}
