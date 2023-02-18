package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class AmountDto (

	@Json(name="value") val value : Float,
	@Json(name="unit") val unit : String
)