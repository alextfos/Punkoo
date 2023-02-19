package com.alextfos.search.ui

import arrow.core.Either
import com.alextfos.search.domain.entity.BeerBo
import com.alextfos.punkoo.common.domain.usecase.Result

data class UiSearchState(
    val loading: Boolean = false,
    val searchResult: Result<List<BeerBo>?> = Either.Right(null)
)
