package com.billysaputra.preparation.helper

import com.billysaputra.preparation.BuildConfig

/**
 * Created by Billy Saputra on 2020-03-10.
 */
class Constants {
    companion object{
        const val BASE_URL = BuildConfig.BASE_URL
        const val API_KEY = BuildConfig.TMDB_API_KEY
    }

    object UrlApi{
        const val GET_SOME_DATA = "/getsomedata"
        const val POST_SOME_DATA = "/postsomedata"

        //TEST
        const val GET_PROMO_BANNERS = "products/promo_banners.json?version=2"
        const val GET_MOVIE = "/3/discover/movie"
    }

    object RequestBody{
        const val BODY_1 = "BODY_1"
        const val BODY_2 = "BODY_2"
    }
}