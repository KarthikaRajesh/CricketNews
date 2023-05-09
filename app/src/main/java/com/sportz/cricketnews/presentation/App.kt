package com.sportz.cricketnews.presentation

import android.app.Application
import com.sportz.cricketnews.BuildConfig
import com.sportz.cricketnews.presentation.di.Injector
import com.sportz.cricketnews.presentation.di.core.*
import com.sportz.cricketnews.presentation.di.matchdetails.MatchDetailSubComponent

class App : Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()


    }

    override fun createMatchDetailSubComponent(): MatchDetailSubComponent {
        return appComponent.matchDetailsSubComponent().create()
    }
}