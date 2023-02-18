package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class MashTempDto (

	@Json(name="temp") val tempDto : TempDto,
	@Json(name="duration") val duration : Int
)