package com.alextfos.feature.data

import com.alextfos.feature.data.api.FeatureApi
import com.alextfos.feature.data.dto.SampleDto
import com.alextfos.punkoo.common.data.extensions.safeBody
import com.alextfos.punkoo.common.exception.EmptyListException

class FeatureRepository(
    private val featureApi: FeatureApi,
) {
    suspend fun get(): SampleDto {
        val result = featureApi.getSample(
        ).safeBody()

        if (result.id.isEmpty()) {
            throw EmptyListException("This result is empty")
        }
        return result
    }
}
