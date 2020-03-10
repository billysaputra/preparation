package com.billysaputra.preparation.helper

import com.billysaputra.preparation.connection.RetrofitCallback
import retrofit2.Call

/**
 * Created by Billy Saputra on 2020-03-10.
 */
internal fun <T> Call<T>.enqueue(callback: RetrofitCallback<T>.() -> Unit) {
    val callBackKt = RetrofitCallback<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}