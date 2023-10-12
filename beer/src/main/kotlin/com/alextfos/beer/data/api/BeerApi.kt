package com.alextfos.beer.data.api

import com.alextfos.punkoo.common.data.versionApi
import com.alextfos.beer.data.dto.BeerDto
import retrofit2.Response
import retrofit2.http.*

interface BeerApi {
    @GET("$versionApi/beers")
    suspend fun getBeerList(
        @Query("beer_name") beerTokens: String? = null,
        @Query("page") page: Int? = null,
        @Query("per_page") pageSize: Int? = null
    ): Response<List<BeerDto>>
}
