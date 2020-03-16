package com.billysaputra.preparation.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoBannerReponse(
    @SerializedName("promo_banners")
    var promoBanners: List<PromoBanner> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class PromoBanner(
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("image")
    var image: String? = "",
    @SerializedName("info")
    var info: Info? = Info()
) : Parcelable

@Parcelize
data class Info(
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("promo_due")
    var promoDue: String? = "",
    @SerializedName("type")
    var type: String? = "",
    @SerializedName("url")
    var url: String? = ""
) : Parcelable