package com.sportz.cricketnews.presentation.di.core

import com.sportz.cricketnews.data.api.CricketApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideMatchApiService(retrofit: Retrofit):CricketApiService{
        return retrofit.create(CricketApiService::class.java)
    }
}