package com.alextfos.punkoo.di

import com.alextfos.search.data.SearchRepository
import com.alextfos.search.data.api.SearchApi
import com.alextfos.search.domain.usecase.GetRandomUseCase
import com.alextfos.search.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SearchModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(searchRepository: SearchRepository) = SearchUseCase(searchRepository)

    @Provides
    @Singleton
    fun provideRandomUseCase(searchRepository: SearchRepository) = GetRandomUseCase(searchRepository)

    @Singleton
    @Provides
    fun providesSearchRepository(
        searchApi: SearchApi
    ) = SearchRepository(searchApi)

    @Provides
    @Singleton
    fun providesSearchApi(
        retrofit: Retrofit
    ): SearchApi =
        retrofit.create(SearchApi::class.java)
}
