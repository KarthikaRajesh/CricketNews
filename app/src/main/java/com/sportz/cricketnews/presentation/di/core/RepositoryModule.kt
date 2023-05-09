package com.sportz.cricketnews.presentation.di.core

import com.sportz.cricketnews.data.repository.MatchDetailRepositoryImpl
import com.sportz.cricketnews.data.repository.datasource.MatchRemoteDataSource
import com.sportz.cricketnews.domain.repository.MatchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMatchDetailRepository(
        matchRemoteDataSource: MatchRemoteDataSource
    ):MatchRepository{
        return MatchDetailRepositoryImpl(matchRemoteDataSource)
    }
}