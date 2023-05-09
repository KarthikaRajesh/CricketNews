package com.sportz.cricketnews.presentation.di.core

import com.sportz.cricketnews.presentation.di.matchdetails.MatchDetailSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class
    ]
)
interface AppComponent {
    fun matchDetailsSubComponent():MatchDetailSubComponent.Factory
}