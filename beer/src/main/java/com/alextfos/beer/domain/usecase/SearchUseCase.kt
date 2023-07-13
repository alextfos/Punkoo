package com.alextfos.beer.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.alextfos.beer.data.BeerRepository
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.domain.mapper.toBeerBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchUseCase(
    private val beerRepository: BeerRepository
) {
    fun invoke(
        searchTokenList: List<String>?
    ): Flow<PagingData<BeerBo>> {
        return beerRepository.getBeerList(searchTokenList).map {
            it.map { beerDto ->
                beerDto.toBeerBo()
            }
        }
    }
}
