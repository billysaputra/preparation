package com.billysaputra.preparation.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CategoriesResponse(
    @SerializedName("categories")
    var categories: List<Category> = arrayListOf()
) : Parcelable, MainResponse()

@Parcelize
data class Category(
    @SerializedName("children")
    var children: List<Children> = arrayListOf(),
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("revamped")
    var revamped: Boolean? = false,
    @SerializedName("url")
    var url: String? = ""
) : Parcelable

@Parcelize
data class Children(
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("revamped")
    var revamped: Boolean? = false,
    @SerializedName("url")
    var url: String? = ""
) : Parcelable