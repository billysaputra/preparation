package com.billysaputra.preparation.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FlashBannerResponse(
    @SerializedName("banners")
    var banners: List<Banner> = arrayListOf()
) : Parcelable, MainResponse()


@Parcelize
data class Banner(
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("image")
    var image: String? = "",
    @SerializedName("info")
    var info: Info? = Info(),
    @SerializedName("open_new_window")
    var openNewWindow: Boolean? = false
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