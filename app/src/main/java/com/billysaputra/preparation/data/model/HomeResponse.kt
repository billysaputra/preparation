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
    @SerializedName("home") var home: ArrayList<Home> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class Home(
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("content_type") var contentType: String? = "",
    @SerializedName("images") var images: List<String> = arrayListOf(),
    @SerializedName("name") var name: String? = "",
    @SerializedName("home_menu") var homeMenu: List<HomeMenu> = arrayListOf(),
    @SerializedName("promo_banner") var promoBanners: List<PromoBanner> = arrayListOf(),
    @SerializedName("top_products") var topProducts: List<TopProduct> = arrayListOf()
) : Parcelable

@Parcelize
data class HomeMenu(
    @SerializedName("menu_name") var menuName: String? = "",
    @SerializedName("menu_image_url") var menuImageUrl: String? = ""
) : Parcelable

@Parcelize
data class TopProduct(
    @SerializedName("product_name") var productName: String? = "",
    @SerializedName("product_image") var productImage: String? = "",
    @SerializedName("product_price") var productPrice: String? = ""
) : Parcelable
