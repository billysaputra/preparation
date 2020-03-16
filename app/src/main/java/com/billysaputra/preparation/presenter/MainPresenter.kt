package com.billysaputra.preparation.presenter

import com.billysaputra.preparation.connection.ConnectionCallback
import com.billysaputra.preparation.connection.ConnectionManager
import com.billysaputra.preparation.connection.RetrofitService
import com.billysaputra.preparation.contract.MainContract
import com.billysaputra.preparation.data.model.PromoBannerReponse
import retrofit2.Call
import retrofit2.Response

class MainPresenter(var mainView : MainContract.View) : MainContract.Presenter{
    private lateinit var connectionManager : ConnectionManager

    override fun initGetPromoBanners() {
        val call = RetrofitService.request.getPromoBanner()
        connectionManager = ConnectionManager()
        connectionManager.connect(call, object : ConnectionCallback{
            override fun onResponse(call: Call<*>, response: Response<*>) {
                val promoBannerResponse = response.body() as PromoBannerReponse
                mainView.showPromoBanner(promoBannerResponse.promoBanners)
            }

            override fun onFailure(call: Call<*>) {

            }
        })
    }
}