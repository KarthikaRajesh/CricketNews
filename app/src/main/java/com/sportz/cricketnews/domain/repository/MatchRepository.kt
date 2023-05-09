package com.sportz.cricketnews.domain.repository

import com.sportz.cricketnews.data.model.MatchApiData

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
interface MatchRepository {
    suspend fun getMatchDetails() : MatchApiData?
}