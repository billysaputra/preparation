package com.billysaputra.preparation.helper

import android.view.View
import com.billysaputra.preparation.connection.RetrofitCallback
import retrofit2.Call

/**
 * Created by Billy Saputra on 2020-03-10.
 */
fun <T> Call<T>.enqueue(callback: RetrofitCallback<T>.() -> Unit) {
    val callBackKt = RetrofitCallback<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone(){
    visibility = View.GONE
}


