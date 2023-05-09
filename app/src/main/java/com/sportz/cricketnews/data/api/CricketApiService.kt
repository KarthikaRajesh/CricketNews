package com.sportz.cricketnews.data.api

import com.sportz.cricketnews.data.model.MatchApiData
import retrofit2.Response
import retrofit2.http.GET

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
interface CricketApiService {
    @GET("nzin01312019187360.json")
    suspend fun getMatchDetails(): Response<MatchApiData>
}