package com.alextfos.beer.data.dto

import com.squareup.moshi.Json

data class BoilVolumeDto (

	@Json(name="value") val value : Int?,
	@Json(name="unit") val unit : String?
)