package com.billysaputra.preparation.presenter

import com.billysaputra.preparation.connection.ConnectionCallback
import com.billysaputra.preparation.connection.ConnectionManager
import com.billysaputra.preparation.connection.RetrofitService
import com.billysaputra.preparation.contract.MainContract
import com.billysaputra.preparation.data.model.CategoriesResponse
import com.billysaputra.preparation.data.model.FlashBannerResponse
import com.billysaputra.preparation.data.model.PopularProductsResponse
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
                mainView.onSuccessGetPromoBanner(promoBannerResponse.promoBanners)
            }

            override fun onFailure(call: Call<*>) {

            }
        })
    }

    override fun initGetFlashBanner() {
        val call = RetrofitService.request.getFlashBanner()
        connectionManager = ConnectionManager()
        connectionManager.connect(call, object : ConnectionCallback{
            override fun onResponse(call: Call<*>, response: Response<*>) {
                val flashBannerReponse = response.body() as FlashBannerResponse
                mainView.onSuccessGetFlashBanner(flashBannerReponse)
            }

            override fun onFailure(call: Call<*>) {

            }
        })
    }

    override fun initGetCategories() {
        val call = RetrofitService.request.getCategories()
        connectionManager = ConnectionManager()
        connectionManager.connect(call, object : ConnectionCallback{
            override fun onResponse(call: Call<*>, response: Response<*>) {
                val categoriesResponse = response.body() as CategoriesResponse
                mainView.onSuccessGetCategories(categoriesResponse)
            }

            override fun onFailure(call: Call<*>) {

            }
        })
    }

    override fun initGetPopularProducts() {
        val call = RetrofitService.request.getPopularProducts()
        connectionManager = ConnectionManager()
        connectionManager.connect(call, object : ConnectionCallback{
            override fun onResponse(call: Call<*>, response: Response<*>) {
                val popularProductsResponse = response.body() as PopularProductsResponse
                mainView.onSuccessGetPopularProducts(popularProductsResponse)
            }

            override fun onFailure(call: Call<*>) {

            }
        })
    }
}