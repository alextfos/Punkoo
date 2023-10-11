package com.alextfos.beer.domain.mapper

import com.alextfos.beer.data.dto.BeerDto
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.common.BeerUi

fun List<BeerDto>.toBeerBoList() = map { it.toBeerBo() }

fun BeerDto.toBeerBo() = BeerBo(
    id = id ?: 0,
    name = name ?: "",
    tagLine = tagline ?: "",
    description = description ?: "",
    imageUrl = imageUrl ?: "",
    ibu = ibu,
    foodPairing = foodPairing ?: listOf(),
    brewersTips = brewersTips ?: ""
)

fun BeerBo.toBeerUi() = BeerUi(
    id = id,
    name = name,
    tagLine = tagLine,
    description = description,
    imageUrl = imageUrl,
    ibu = ibu?.let {
        String.format("%.1f", it)
    } ?: run {
        ""
    },
    foodPairing = foodPairing,
    brewersTips = brewersTips
)