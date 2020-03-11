package com.billysaputra.preparation.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "home_table")
data class SampleDataClass(
    @PrimaryKey @SerializedName("id") var id: Int? = 0,
    @SerializedName("content_type") var contentType: String? = "",
    @SerializedName("name") var name: String? = ""
) : Parcelable