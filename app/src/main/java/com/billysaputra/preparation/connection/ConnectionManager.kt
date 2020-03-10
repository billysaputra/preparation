package com.billysaputra.preparation.connection

import android.util.Log
import com.billysaputra.preparation.helper.enqueue
import retrofit2.Call
import retrofit2.Response

/**
 * Created by Billy Saputra on 2020-03-10.
 */
class ConnectionManager {
    private val TAG = ConnectionManager::class.java.simpleName
    private lateinit var mConnectionCallback: ConnectionCallback
    private lateinit var mCall: Call<*>

    fun connect(mCall: Call<*>, mConnectionCallback: ConnectionCallback) {
        this.mCall = mCall
        this.mConnectionCallback = mConnectionCallback
        callAPIRequest()
    }

    private fun callAPIRequest() {
        mCall.clone().enqueue {
            onResponse = { call: Call<out Any>, response: Response<out Any> ->
                Log.i(TAG, "onResponse, URL :${call.request().url()}")
                mConnectionCallback.onResponse(call, response)
            }
            onFailure = { call: Call<out Any>, t: Throwable? ->
                Log.i(TAG, "onFailure, URL: ${call.request().url()}")
                mConnectionCallback.onFailure(call)
            }
        }
    }
}