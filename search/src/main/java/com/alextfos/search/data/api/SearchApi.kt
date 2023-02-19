package com.alextfos.search.data.api

import com.alextfos.punkoo.common.data.versionApi
import com.alextfos.search.data.dto.BeerDto
import retrofit2.Response
import retrofit2.http.*

interface SearchApi {
    @GET("$versionApi/beers")
    suspend fun searchBeers(
        @Query("beer_name") beerTokens: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Response<List<BeerDto>>
}
