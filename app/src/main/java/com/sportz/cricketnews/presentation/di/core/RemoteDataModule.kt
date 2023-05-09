package com.sportz.cricketnews.presentation.di.core

import com.sportz.cricketnews.data.api.CricketApiService
import com.sportz.cricketnews.data.repository.datasource.MatchRemoteDataSource
import com.sportz.cricketnews.data.repository.datasourceimpl.MatchRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideMatchDetailDataSource(cricketApiService: CricketApiService):MatchRemoteDataSource{
        return MatchRemoteDataSourceImpl(
            cricketApiService
        )
    }
}