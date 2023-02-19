package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class IngredientsDto (

	@Json(name="malt") val maltDto : List<MaltDto>?,
	@Json(name="hops") val hops : List<HopDto>?,
	@Json(name="yeast") val yeast : String?
)