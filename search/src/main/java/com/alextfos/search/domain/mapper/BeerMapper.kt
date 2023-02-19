package com.alextfos.search.domain.mapper

import com.alextfos.search.data.dto.BeerDto
import com.alextfos.search.domain.entity.BeerBo

fun BeerDto.toBeerBo() = BeerBo(
    id = id ?: 0,
    name = name ?: ""
)