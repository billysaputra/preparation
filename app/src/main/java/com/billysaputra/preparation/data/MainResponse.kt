package com.billysaputra.preparation.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Billy Saputra on 2020-03-10.
 */
@Parcelize
data class MainResponse(
    @SerializedName("message") var message: String? = "",
    @SerializedName("status") var status: String? = ""
) : Parcelable