package com.alextfos.search.domain.usecase

import com.alextfos.punkoo.common.domain.usecase.runUseCase
import com.alextfos.search.data.SearchRepository
import com.alextfos.search.domain.mapper.toBeerBoList

class GetRandomUseCase(
    private val searchRepository: SearchRepository
) {
    suspend fun invoke() = runUseCase {
        searchRepository.getRandomBeer().toBeerBoList()[0]
    }
}