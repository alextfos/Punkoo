package com.alextfos.punkoo.di

import com.alextfos.beer.data.BeerRepository
import com.alextfos.beer.data.api.BeerApi
import com.alextfos.beer.domain.usecase.GetRandomBeerUseCase
import com.alextfos.beer.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BeerModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(beerRepository: BeerRepository) =
        SearchUseCase(beerRepository)

    @Provides
    @Singleton
    fun provideRandomBeerUseCase(beerRepository: BeerRepository) =
        GetRandomBeerUseCase(beerRepository)

    @Singleton
    @Provides
    fun providesBeerRepository(
        beerApi: BeerApi
    ) = BeerRepository(beerApi)

    @Provides
    @Singleton
    fun providesBeerApi(
        retrofit: Retrofit
    ): BeerApi =
        retrofit.create(BeerApi::class.java)
}
