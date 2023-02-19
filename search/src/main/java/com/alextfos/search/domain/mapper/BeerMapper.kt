package com.alextfos.search.domain.mapper

import com.alextfos.search.data.dto.BeerDto
import com.alextfos.search.domain.entity.BeerBo

fun List<BeerDto>.toBeerBoList() = map { it.toBeerBo() }

fun BeerDto.toBeerBo() = BeerBo(
    id = id ?: 0,
    name = name ?: ""
)