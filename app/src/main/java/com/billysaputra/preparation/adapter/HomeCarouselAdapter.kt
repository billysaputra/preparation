package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Banner
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_carousel.view.*

/**
 * Created by Billy Saputra on 2020-03-11.
 */
class HomeCarouselAdapter(private var bannerList : List<Banner>) : PagerAdapter(){

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return bannerList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(container.context)
        val view = layoutInflater.inflate(R.layout.item_carousel, container, false)
        Glide.with(view.iv_carousel.context)
            .load(bannerList[position].image)
            .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
            .into(view.iv_carousel)
        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}