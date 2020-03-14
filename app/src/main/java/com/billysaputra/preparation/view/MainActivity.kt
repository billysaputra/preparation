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
import com.billysaputra.preparation.data.model.Home
import com.billysaputra.preparation.data.model.HomeResponse
import com.billysaputra.preparation.data.model.PromoBanner
import com.billysaputra.preparation.helper.Utils
import com.billysaputra.preparation.presenter.MainPresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_home.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private var isDoubleBackPressedTriggered = false
    private var homeAdapter : HomeAdapter? = null
    private var mainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListener()
        mainPresenter.initGetPromoBanners()
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

    private fun initHomeAdapter(promoBannerList: List<PromoBanner>){
        val dummyResponse = Utils.inputStreamToString(resources.openRawResource(R.raw.dummy_response))
        val homeModel = Gson().fromJson(dummyResponse, HomeResponse::class.java)
        homeModel.home.add(Home().apply {
            contentType = "PROMO_BANNER"
            promoBanners = promoBannerList
        })
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

    override fun showPromoBanner(promoBannerList: List<PromoBanner>) {
        println("List of promo banner size : ${promoBannerList.size}")

        initHomeAdapter(promoBannerList)
    }
}
