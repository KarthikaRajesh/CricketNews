package com.sportz.cricketnews.data.repository

import android.util.Log
import com.sportz.cricketnews.data.model.MatchApiData
import com.sportz.cricketnews.data.repository.datasource.MatchRemoteDataSource
import com.sportz.cricketnews.domain.repository.MatchRepository

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
class MatchDetailRepositoryImpl(
    private val matchRemoteDataSource: MatchRemoteDataSource
) : MatchRepository {
    override suspend fun getMatchDetails(): MatchApiData? {
        return getMatchDetailFromAPI()
    }
    suspend fun getMatchDetailFromAPI() : MatchApiData{
        lateinit var matchApiData: MatchApiData
        try{
            val response = matchRemoteDataSource.getMatchDetails()
            val body = response.body()
            if(body != null){
                matchApiData = body
            }
        }catch (exception : Exception){
            Log.i("My Tag",exception.toString())
        }
        return matchApiData
    }

}