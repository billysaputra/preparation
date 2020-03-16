package com.billysaputra.preparation.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("page") var page: Int = 0,
    @SerializedName("total_results") var totalResults: Int = 0,
    @SerializedName("results") var results: ArrayList<MovieItem> = arrayListOf()
) : Parcelable

@Parcelize
data class MovieItem(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("title") var title: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("poster_path") var posterPath: String? = null,
    @SerializedName("release_date") var releaseDate: String = "",
    @SerializedName("overview") var overview: String = "",
    @SerializedName("vote_average") var voteAverage: Double = 0.0
) : Parcelable