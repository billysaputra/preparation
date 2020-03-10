package com.billysaputra.preparation.connection

import retrofit2.Call
import retrofit2.Response

/**
 * Created by Billy Saputra on 2020-03-10.
 */
interface ConnectionCallback {
    fun onResponse(call: Call<*>, response: Response<*>)
    fun onFailure(call: Call<*>)
}