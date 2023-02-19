package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class MethodDto (

	@Json(name="mash_temp") val mash_tempDto : List<MashTempDto>?,
	@Json(name="fermentation") val fermentationDto : FermentationDto?,
	@Json(name="twist") val twist : String?
)