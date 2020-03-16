package com.billysaputra.preparation.contract

import com.billysaputra.preparation.data.model.PromoBanner

interface MainContract {
    interface View{
        fun showPromoBanner(promoBannerList : List<PromoBanner>)
    }

    interface Presenter{
        fun initGetPromoBanners()
    }
}