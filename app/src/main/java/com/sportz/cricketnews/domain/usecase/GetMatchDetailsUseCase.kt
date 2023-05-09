package com.sportz.cricketnews.domain.usecase

import com.sportz.cricketnews.data.model.MatchApiData
import com.sportz.cricketnews.domain.repository.MatchRepository

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
class GetMatchDetailsUseCase(private val matchRepository: MatchRepository) {
    suspend fun execute():MatchApiData? = matchRepository.getMatchDetails()
}