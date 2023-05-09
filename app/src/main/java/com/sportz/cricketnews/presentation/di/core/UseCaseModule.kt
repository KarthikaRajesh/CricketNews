package com.sportz.cricketnews.presentation.di.core

import com.sportz.cricketnews.domain.repository.MatchRepository
import com.sportz.cricketnews.domain.usecase.GetMatchDetailsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun getProvidesMatchDetailsUseCase(
        matchRepository: MatchRepository
    ):GetMatchDetailsUseCase{
        return GetMatchDetailsUseCase(matchRepository)
    }
}