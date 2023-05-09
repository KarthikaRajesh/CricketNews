package com.sportz.cricketnews.data.repository.datasource

import com.sportz.cricketnews.data.model.MatchApiData
import retrofit2.Response

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
interface MatchRemoteDataSource {
    suspend fun getMatchDetails() : Response<MatchApiData>
}