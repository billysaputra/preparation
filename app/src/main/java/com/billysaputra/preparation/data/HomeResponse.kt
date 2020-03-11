package com.billysaputra.preparation.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Billy Saputra on 2020-03-11.
 */
@Parcelize
data class HomeResponse(
    @SerializedName("home") var home: List<Home> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class Home(
    @SerializedName("content_type") var contentType: String? = "",
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("images") var images: List<String> = arrayListOf(),
    @SerializedName("name") var name: String? = ""
) : Parcelable