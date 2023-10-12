package com.alextfos.beer.data.util

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


fun providesRetrofit(
    okHttpClient: OkHttpClient
): Retrofit {
    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/")
        .addConverterFactory(MoshiConverterFactory.create(providesMoshi()))
        .client(okHttpClient)
    return retrofitBuilder.build()
}

fun providesOkHttp(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient().newBuilder()

    okHttpClientBuilder
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(10L, TimeUnit.SECONDS)
        .connectTimeout(10L, TimeUnit.SECONDS)

    return okHttpClientBuilder.build()
}

private fun providesMoshi(): Moshi =
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()