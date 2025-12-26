package com.seenu.weatherapp.di

import com.seenu.weatherapp.data.api.WeatherApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesMoshi() : Moshi{
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ) : Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .baseUrl("https://api.weatherapi.com/v1/")
            .build()
    }

    @Provides
    @Singleton
    fun providesWeatherApi(
        retrofit: Retrofit
    ) : WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}