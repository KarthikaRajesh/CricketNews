package com.sportz.cricketnews.presentation.di

import com.sportz.cricketnews.presentation.di.matchdetails.MatchDetailSubComponent

interface Injector {
    fun createMatchDetailSubComponent():MatchDetailSubComponent
}