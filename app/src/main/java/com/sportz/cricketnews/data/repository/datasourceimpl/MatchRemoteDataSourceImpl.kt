package com.sportz.cricketnews.data.repository.datasourceimpl

import com.sportz.cricketnews.data.api.CricketApiService
import com.sportz.cricketnews.data.model.MatchApiData
import com.sportz.cricketnews.data.repository.datasource.MatchRemoteDataSource
import retrofit2.Response

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
class MatchRemoteDataSourceImpl(
    private val cricketApiService: CricketApiService)
    : MatchRemoteDataSource {

    override suspend fun getMatchDetails(): Response<MatchApiData> = cricketApiService.getMatchDetails()

}