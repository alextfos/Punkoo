package com.alextfos.search.data.dto

import com.squareup.moshi.Json

data class HopDto (

    @Json(name="name") val name : String?,
    @Json(name="amount") val amountDto : AmountDto?,
    @Json(name="add") val add : String?,
    @Json(name="attribute") val attribute : String?
)