package com.alextfos.beer.domain.usecase

import com.alextfos.beer.data.BeerRepository
import com.alextfos.beer.domain.SampleBeerBuilder

class GetRandomBeerUseCase(
    private val beerRepository: BeerRepository
) {
    suspend fun invoke() = SampleBeerBuilder().buildSingle()
        //beerRepository.getRandomBeer().toBeerBoList()[0]
}