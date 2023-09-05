package com.alextfos.beer.data.dto

import com.squareup.moshi.Json

data class TempDto (

	@Json(name="value") val value : Int?,
	@Json(name="unit") val unit : String?
)