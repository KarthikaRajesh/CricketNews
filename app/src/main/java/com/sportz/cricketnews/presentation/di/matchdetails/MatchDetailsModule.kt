package com.sportz.cricketnews.presentation.di.matchdetails

import com.sportz.cricketnews.domain.usecase.GetMatchDetailsUseCase
import com.sportz.cricketnews.presentation.matchdetail.MatchDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MatchDetailsModule {
    @MatchDetailScope
    @Provides
    fun provideMatchDetailViewModelFactory(
        getMatchDetailsUseCase: GetMatchDetailsUseCase
    ):MatchDetailViewModelFactory{
        return MatchDetailViewModelFactory(getMatchDetailsUseCase)
    }
}