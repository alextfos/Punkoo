package com.alextfos.punkoo.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.alextfos.punkoo.BuildConfig
import com.alextfos.punkoo.common.data.interceptors.ConnectivityInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    private val defaultTimeOut: Long = 10

    @Provides
    @Singleton
    fun providesNewsApiRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BuildConfig.CONFIG_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(providesMoshi()))
            .client(okHttpClient)
        return retrofitBuilder.build()
    }

    @Provides
    @Singleton
    fun providesOkHttp(
        @ApplicationContext context: Context,
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient().newBuilder()

        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        val chuckerInterceptor = ChuckerInterceptor.Builder(context)
            .collector(chuckerCollector)
            .alwaysReadResponseBody(true)
            .build()


        okHttpClientBuilder
            //.addInterceptor(chuckerInterceptor) TODO not working
            /*.addInterceptor(ConnectivityInterceptor(context))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })*/
            .readTimeout(defaultTimeOut, TimeUnit.SECONDS)
            .connectTimeout(defaultTimeOut, TimeUnit.SECONDS)

        return okHttpClientBuilder.build()
    }

    private fun providesMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

}