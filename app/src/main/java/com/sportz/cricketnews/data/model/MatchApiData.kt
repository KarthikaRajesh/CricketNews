package com.sportz.cricketnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
data class MatchApiData(
    @SerializedName("Matchdetail")
    val matchDetail: MatchDetail,
    @SerializedName("Teams")
    val teams : Map<String, Teams>
)
