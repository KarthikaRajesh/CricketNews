package com.sportz.cricketnews.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Players(
    @SerializedName("Batting")
    val batting: Batting,
    @SerializedName("Bowling")
    val bowling: Bowling,
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Position")
    val position: String,
    @SerializedName("Iskeeper")
    val isKeeper: Boolean = false,
    @SerializedName("Iscaptain")
    val isCaptain: Boolean = false
):Parcelable