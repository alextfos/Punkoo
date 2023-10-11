package com.alextfos.beer.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.alextfos.beer.data.BeerRepository
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.domain.mapper.toBeerBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetBeerListUseCase @Inject constructor(
    private val beerRepository: BeerRepository
) {
    fun invoke() : Flow<PagingData<BeerBo>> =
         beerRepository.getBeerList().map {
            it.map { beerDto ->
                beerDto.toBeerBo()
            }
        }
}
