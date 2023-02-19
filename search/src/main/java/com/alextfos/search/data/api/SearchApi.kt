package com.alextfos.search.data.api

import com.alextfos.search.data.dto.BeerDto
import retrofit2.Response
import retrofit2.http.*

interface SearchApi {
    @GET("/beers")
    suspend fun searchBeers(
        @Query("beer_name") beerTokens: String,
        @Query("page") page: Int,
        @Query("per_page") itemsByPage: Int
    ): Response<List<BeerDto>>

    @GET("/beers/random")
    suspend fun getRandomBeerList(): Response<List<BeerDto>>
}
