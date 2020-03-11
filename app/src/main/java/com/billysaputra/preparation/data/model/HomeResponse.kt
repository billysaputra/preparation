package com.billysaputra.preparation.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("content_type") var contentType: String? = "",
    @SerializedName("images") var images: List<String> = arrayListOf(),
    @SerializedName("name") var name: String? = ""
) : Parcelable
