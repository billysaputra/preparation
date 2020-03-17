package com.billysaputra.preparation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.billysaputra.preparation.R
import com.billysaputra.preparation.adapter.HomeAdapter
import com.billysaputra.preparation.contract.MainContract
import com.billysaputra.preparation.data.model.*
import com.billysaputra.preparation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_home.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private var isDoubleBackPressedTriggered = false
    private var homeAdapter : HomeAdapter? = null
    private var mainPresenter = MainPresenter(this)
    private var homeModel = HomeResponse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListener()
        mainPresenter.initGetFlashBanner()
    }

    override fun onBackPressed() {
        if (isDoubleBackPressedTriggered) {
            super.onBackPressed()
            return
        }
        this.isDoubleBackPressedTriggered = true
        Toast.makeText(this, getString(R.string.double_back_pressed_to_exit), Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ isDoubleBackPressedTriggered = false }, 2000)
    }

    /*private fun initHomeAdapter(promoBannerList: List<PromoBanner>){
        val dummyResponse = Utils.inputStreamToString(resources.openRawResource(R.raw.dummy_response))
        val homeModel = Gson().fromJson(dummyResponse, HomeResponse::class.java)
        homeModel.home.add(Home().apply {
            contentType = "PROMO_BANNER"
            promoBanners = promoBannerList
        })
        homeAdapter = HomeAdapter(this, homeModel.home)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = homeAdapter
    }*/
    private fun addFlashBanner(banners : List<Banner>){
        homeModel.home.add(Home().apply {
            contentType = "CAROUSEL"
            flashBanner =  banners
        })
    }

    private fun addCategories(categoryList : List<Category>){
        homeModel.home.add(Home().apply {
            contentType = "CATEGORIES"
            categories = categoryList
        })
    }

    private fun addPromoBanner(promoBannerList: List<PromoBanner>){
        homeModel.home.add(Home().apply {
            contentType = "PROMO_BANNER"
            promoBanners = promoBannerList
        })
    }

    private fun addTopProducts(productList: List<Product>){
        homeModel.home.add(Home().apply {
            contentType = "TOP_PRODUCT"
            products = productList
        })
    }

    private fun initAdapter(){
        homeAdapter = HomeAdapter(this, homeModel.home)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = homeAdapter
    }

    private fun setOnClickListener() {
        btn_tab_activity.setOnClickListener {
            startActivity(Intent(this, ExperimentActivity::class.java))
        }
        iv_chat.setOnClickListener {
            startActivity(Intent(this, TabActivity::class.java))
        }
        iv_notification.setOnClickListener {

        }
        iv_cart.setOnClickListener {

        }
    }



    override fun onSuccessGetFlashBanner(flashBannerResponse: FlashBannerResponse) {
        addFlashBanner(flashBannerResponse.banners)
        mainPresenter.initGetCategories()
    }

    override fun onSuccessGetCategories(categoriesResponse: CategoriesResponse) {
        addCategories(categoriesResponse.categories)
        mainPresenter.initGetPromoBanners()
    }

    override fun onSuccessGetPromoBanner(promoBannerList: List<PromoBanner>) {
        addPromoBanner(promoBannerList)
        mainPresenter.initGetPopularProducts()
    }

    override fun onSuccessGetPopularProducts(popularProductsResponse: PopularProductsResponse) {
        for(popular in popularProductsResponse.populars){
            addTopProducts(popular.products)
        }
        initAdapter()
    }
}
