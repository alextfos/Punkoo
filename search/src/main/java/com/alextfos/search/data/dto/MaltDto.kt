package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class MaltDto (

	@Json(name="name") val name : String?,
	@Json(name="amount") val amountDto : AmountDto?
)