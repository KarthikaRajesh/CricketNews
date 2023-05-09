package com.sportz.cricketnews.presentation.matchdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sportz.cricketnews.domain.usecase.GetMatchDetailsUseCase

class MatchDetailViewModel(
    private val matchDetailsUseCase: GetMatchDetailsUseCase
) : ViewModel() {

    val getMatchDetails = liveData {
        val matchApiData = matchDetailsUseCase.execute()
        emit(matchApiData)
    }
}