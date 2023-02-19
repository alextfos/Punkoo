package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class FermentationDto (

	@Json(name="temp") val tempDto : TempDto?
)