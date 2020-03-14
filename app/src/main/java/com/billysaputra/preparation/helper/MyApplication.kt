package com.billysaputra.preparation.helper

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
        UserPreferences.init(this)
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    fun hasNetwork(): Boolean {
        var isConnected = false
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}