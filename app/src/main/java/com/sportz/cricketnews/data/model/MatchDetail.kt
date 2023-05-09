package com.sportz.cricketnews.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
data class MatchDetail(
    @SerializedName("Team_Home")
    val teamHome: String,
    @SerializedName("Team_Away")
    val teamAway: String,
    @SerializedName("Match")
    val match: Match,
    @SerializedName("Series")
    val series: Series,
    @SerializedName("Venue")
    val venue: Venue,
    @SerializedName("Weather")
    val weather: String,
    @SerializedName("Tosswonby")
    val tossWonBy: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Player_Match")
    val playerMatch: String,
    @SerializedName("Result")
    val result: String
)
