package com.billysaputra.preparation.connection

import com.billysaputra.preparation.data.model.MainResponse
import com.billysaputra.preparation.data.model.MovieResponse
import com.billysaputra.preparation.data.model.PromoBannerReponse
import com.billysaputra.preparation.helper.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Billy Saputra on 2020-03-10.
 */
interface APICollections {

    @GET(Constants.UrlApi.GET_SOME_DATA)
    fun getSomeData(
        @Query("q1") query1: String,
        @Query("q2") query2: String
    ): Call<MainResponse>

    @POST(Constants.UrlApi.POST_SOME_DATA)
    fun postSomeData(@Body body: Map<String, String>): Call<MainResponse>

    //TEST
    @GET(Constants.UrlApi.GET_MOVIE)
    fun getMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<MovieResponse>

    @GET(Constants.UrlApi.GET_PROMO_BANNERS)
    fun getPromoBanner() : Call<PromoBannerReponse>
}