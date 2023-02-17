package com.alextfos.feature.data.api

import com.alextfos.feature.data.dto.SampleDto
import retrofit2.Response
import retrofit2.http.*

interface FeatureApi {
    @GET("/sample")
    suspend fun getSample(): Response<SampleDto>
}
