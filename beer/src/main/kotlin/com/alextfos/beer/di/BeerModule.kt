package com.alextfos.beer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BeerModule {
    @Provides
    @Named("beerDetail")
    @Singleton
    fun provideBeerDetailContainer(): BeerDetailContainer = BeerDetailContainer()
}
