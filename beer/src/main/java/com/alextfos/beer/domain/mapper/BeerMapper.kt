package com.alextfos.beer.domain.mapper

import com.alextfos.beer.data.dto.BeerDto
import com.alextfos.beer.domain.entity.BeerBo

fun List<BeerDto>.toBeerBoList() = map { it.toBeerBo() }

fun BeerDto.toBeerBo() = BeerBo(
    id = id ?: 0,
    name = name ?: ""
)