package com.alextfos.beer.domain.usecase

import com.alextfos.punkoo.common.domain.usecase.runUseCase
import com.alextfos.beer.data.BeerRepository
import com.alextfos.beer.domain.mapper.toBeerBoList

class GetRandomBeerUseCase(
    private val beerRepository: BeerRepository
) {
    suspend fun invoke() = runUseCase {
        beerRepository.getRandomBeer().toBeerBoList()[0]
    }
}