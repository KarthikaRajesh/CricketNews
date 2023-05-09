package com.sportz.cricketnews.presentation.matchdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sportz.cricketnews.domain.usecase.GetMatchDetailsUseCase

class MatchDetailViewModelFactory(
    private val matchDetailsUseCase: GetMatchDetailsUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MatchDetailViewModel(matchDetailsUseCase) as T
    }

}