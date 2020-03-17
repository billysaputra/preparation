package com.billysaputra.preparation.contract

import com.billysaputra.preparation.data.model.CategoriesResponse
import com.billysaputra.preparation.data.model.FlashBannerResponse
import com.billysaputra.preparation.data.model.PopularProductsResponse
import com.billysaputra.preparation.data.model.PromoBanner

interface MainContract {
    interface View{
        fun onSuccessGetPromoBanner(promoBannerList : List<PromoBanner>)
        fun onSuccessGetFlashBanner(flashBannerResponse: FlashBannerResponse)
        fun onSuccessGetCategories(categoriesResponse: CategoriesResponse)
        fun onSuccessGetPopularProducts(popularProductsResponse: PopularProductsResponse)

    }

    interface Presenter{
        fun initGetFlashBanner()
        fun initGetCategories()
        fun initGetPopularProducts()
        fun initGetPromoBanners()
    }
}