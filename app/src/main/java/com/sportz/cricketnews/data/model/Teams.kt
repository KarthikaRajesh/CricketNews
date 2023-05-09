package com.sportz.cricketnews.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.Parcelize

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 08-05-2023
 */
@Parcelize
data class Teams(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Name_Short")
    val nameShort : String,
    @SerializedName("Players")
    val players : Map<String, Players>
):Parcelable