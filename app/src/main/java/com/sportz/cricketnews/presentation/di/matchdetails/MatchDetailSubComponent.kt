package com.sportz.cricketnews.presentation.di.matchdetails

import com.sportz.cricketnews.presentation.matchdetail.MatchDetailActivity
import dagger.Subcomponent
@MatchDetailScope
@Subcomponent(
    modules = [
        MatchDetailsModule::class
    ]
)
interface MatchDetailSubComponent {
    fun inject(matchDetailActivity: MatchDetailActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MatchDetailSubComponent
    }
}