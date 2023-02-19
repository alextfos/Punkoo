package com.alextfos.beer.ui

import arrow.core.Either
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.common.domain.usecase.Result

data class BeerBoUiState(
    val loading: Boolean = false,
    val searchResult: Result<BeerBo?> = Either.Right(null)
)
