package com.billysaputra.preparation.helper

import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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


/**
 * View
 * */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone(){
    visibility = View.GONE
}

/**
 * Fragment Manager
 * */

fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}


