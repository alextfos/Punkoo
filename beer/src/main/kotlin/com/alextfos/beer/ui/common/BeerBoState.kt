package com.alextfos.beer.ui.common

import arrow.core.Either
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.common.domain.usecase.UseCaseResult

data class BeerBoState(
    val loading: Boolean = false,
    val searchResult: UseCaseResult<BeerBo?> = Either.Right(null)
)
