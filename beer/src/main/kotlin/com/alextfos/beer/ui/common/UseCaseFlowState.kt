package com.alextfos.beer.ui.common

import androidx.paging.PagingData
import arrow.core.Either
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.punkoo.common.domain.usecase.UseCaseResult
import kotlinx.coroutines.flow.Flow

data class BeerBoFlowState(
    val loading: Boolean = false,
    val beerList: UseCaseResult<Flow<PagingData<BeerBo>>?> = Either.Right(null)
)
