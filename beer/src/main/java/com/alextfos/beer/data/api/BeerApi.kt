package com.alextfos.beer.data.api

import com.alextfos.punkoo.common.data.versionApi
import com.alextfos.beer.data.dto.BeerDto
import retrofit2.Response
import retrofit2.http.*

interface BeerApi {
    @GET("$versionApi/beers")
    suspend fun searchBeers(
        @Query("beer_name") beerTokens: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Response<List<BeerDto>>

  @GET("$versionApi/beers/random")
  suspend fun getRandomBeer(): Response<List<BeerDto>>
}
