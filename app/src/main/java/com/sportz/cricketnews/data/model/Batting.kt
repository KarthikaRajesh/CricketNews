package com.sportz.cricketnews.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batting(
    @SerializedName("Average")
    val average: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Strikerate")
    val strikerate: String,
    @SerializedName("Style")
    val style: String
):Parcelable