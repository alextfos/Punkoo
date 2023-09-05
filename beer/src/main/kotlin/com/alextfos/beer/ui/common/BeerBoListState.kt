package com.alextfos.beer.ui.common

import arrow.core.Either
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.common.domain.usecase.UseCaseResult

data class BeerBoListState(
    val loading: Boolean = false,
    val beerList: UseCaseResult<List<BeerBo>?> = Either.Right(null)
)
