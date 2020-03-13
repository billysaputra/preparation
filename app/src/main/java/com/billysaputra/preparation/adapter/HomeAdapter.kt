package com.billysaputra.preparation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Home
import java.lang.RuntimeException
import androidx.recyclerview.widget.GridLayoutManager
import com.billysaputra.preparation.helper.CustomGridItemDecoration
import kotlinx.android.synthetic.main.item_home_carousel.view.*
import kotlinx.android.synthetic.main.item_home_menu.view.*
import kotlinx.android.synthetic.main.item_home_six_grid.view.*

/**
 * Created by Billy Saputra on 2020-03-10.
 */
class HomeAdapter(private val context: Context, private val home : List<Home>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_CAROUSEL = 0
    private val TYPE_SIX_GRID = 1
    private val TYPE_MENU = 2

    override fun getItemViewType(position: Int): Int {
        return when (home[position].contentType) {
            "CAROUSEL" -> TYPE_CAROUSEL
            "SIX_GRID" -> TYPE_SIX_GRID
            else -> TYPE_MENU
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CAROUSEL -> {
                CarouselHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_carousel, parent, false))
            }
            TYPE_SIX_GRID -> {
                SixGridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_six_grid, parent, false))
            }
            TYPE_MENU -> {
                MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false))
            }
            else -> throw RuntimeException(context.getString(R.string.view_type_exception, viewType))
        }
    }

    override fun getItemCount(): Int {
        return home.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            TYPE_CAROUSEL ->{
                holder as CarouselHolder
                holder.setCarousel(home[position])
            }
            TYPE_SIX_GRID ->{
                holder as SixGridViewHolder
                holder.setupSixGridImage(home[position])
            }
            TYPE_MENU ->{
                holder as MenuViewHolder
                holder.setMenu(home[position])
            }
        }
    }

    inner class CarouselHolder(item : View) : RecyclerView.ViewHolder(item){
        fun setCarousel(home : Home){
            val carouselAdapter = HomeCarouselAdapter(home.images)
            itemView.vp_carousel.adapter = carouselAdapter

            /*val colors: IntArray = intArrayOf(
                context.resources.getColor(R.color.colorAccent),
                context.resources.getColor(R.color.colorPrimary),
                context.resources.getColor(R.color.colorPrimaryDark)
            )
            val argbEvaluator = ArgbEvaluator()

            itemView.vp_carousel.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    if(position < (carouselAdapter.count-1) && position < (colors.size - 1)){
                        itemView.vp_carousel.setBackgroundColor(
                            argbEvaluator.evaluate(positionOffset,
                            colors[position],
                            colors[position+1])as Int)
                    }else{
                        itemView.vp_carousel.setBackgroundColor(colors[colors.size - 1])
                    }
                }

                override fun onPageSelected(position: Int) {

                }
            })*/
        }
    }

    inner class SixGridViewHolder(item : View) : RecyclerView.ViewHolder(item){
        fun setupSixGridImage(home : Home) {
            itemView.tv_header.text = home.name
            itemView.rv_six_grid.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            val sixGridImageAdapter = SixGridImageAdapter(context, home.images)
            itemView.rv_six_grid.adapter = sixGridImageAdapter
        }
    }

    inner class MenuViewHolder(item : View) : RecyclerView.ViewHolder(item){
        fun setMenu(home: Home){
            itemView.tv_header_menu.text = home.name
            itemView.rv_home_menu.layoutManager = GridLayoutManager(context,4, GridLayoutManager.VERTICAL, false)
            val homeMenuAdapter = MenuGridAdapter(home.homeMenu)
            itemView.rv_home_menu.adapter = homeMenuAdapter
            //itemView.rv_home_menu.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
    }

}