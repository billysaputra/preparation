package com.billysaputra.preparation.connection

import com.billysaputra.preparation.helper.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Billy Saputra on 2020-03-10.
 */
class RetrofitService {

    companion object {
        private const val REQUEST_TIMEOUT = 10000L
        //private val gson = GsonBuilder().setLenient().create()
        private val okHttpClient = OkHttpClient.Builder()
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()
        /*private const val cacheSize = (5 * 1024 * 1024).toLong()
        private val myCache = Cache(MyApplication.instance.applicationContext.cacheDir, cacheSize)
        private val okHttpClient = OkHttpClient.Builder()
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (MyApplication.instance.hasNetwork()) {
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                } else {
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=" + 5
                    ).build()
                }
                chain.proceed(request)
            }
            .build()*/

        val request: APICollections by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            retrofit.create(APICollections::class.java)
        }
    }
}