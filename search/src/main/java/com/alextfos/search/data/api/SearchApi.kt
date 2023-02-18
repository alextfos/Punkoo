package com.alextfos.search.data.api

import com.alextfos.search.data.dto.BeerDto
import retrofit2.Response
import retrofit2.http.*

interface SearchApi {
    @GET("/beers")
    suspend fun searchBeers(
        @Query("page") page: Int,
        @Query("per_page") itemsByPage: Int
    ): Response<List<BeerDto>>
}
