package com.alextfos.feature.data.dto

import com.squareup.moshi.Json

data class SampleDto(
    @Json(name = "id") val id: String = "",
)