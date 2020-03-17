package com.billysaputra.preparation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Home
import java.lang.RuntimeException
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.billysaputra.preparation.data.model.Category
import kotlinx.android.synthetic.main.item_home_carousel.view.*
import kotlinx.android.synthetic.main.item_home_menu.view.*
import kotlinx.android.synthetic.main.item_home_menu.view.rv_home_menu

/**
 * Created by Billy Saputra on 2020-03-10.
 */
class HomeAdapter(private val context: Context, private val home : List<Home>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_CAROUSEL = 0
    private val TYPE_SIX_GRID = 1
    private val TYPE_MENU = 2
    private val TYPE_PROMO_BANNER = 3
    private val TYPE_TWO_ROW_GRID = 4
    private val TYPE_TOP_PRODUCT = 5
    private val TYPE_CATEGORIES = 6

    override fun getItemViewType(position: Int): Int {
        return when (home[position].contentType) {
            "CAROUSEL" -> TYPE_CAROUSEL
            "SIX_GRID" -> TYPE_SIX_GRID
            "MENU" -> TYPE_MENU
            "PROMO_BANNER" -> TYPE_PROMO_BANNER
            "TWO_ROW_GRID" -> TYPE_TWO_ROW_GRID
            "TOP_PRODUCT" -> TYPE_TOP_PRODUCT
            else -> TYPE_CATEGORIES
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CAROUSEL -> {
                CarouselHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_carousel, parent, false))
            }
            TYPE_SIX_GRID -> {
                SixGridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false))
            }
            TYPE_MENU -> {
                MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false))
            }
            TYPE_PROMO_BANNER ->{
                PromoBannerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false))
            }
            TYPE_TWO_ROW_GRID ->{
                TwoRowGridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu_without_header, parent, false))
            }
            TYPE_TOP_PRODUCT ->{
                TopProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false))
            }
            TYPE_CATEGORIES ->{
                CategoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_menu, parent, false))
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
            TYPE_PROMO_BANNER ->{
                holder as PromoBannerViewHolder
                holder.setPromoBanner(home[position])
            }
            TYPE_TWO_ROW_GRID ->{
                holder as TwoRowGridViewHolder
                holder.setTwoRowGrid(home[position])
            }
            TYPE_TOP_PRODUCT ->{
                holder as TopProductViewHolder
                holder.setTopProduct(home[position])
            }
            TYPE_CATEGORIES ->{
                holder as CategoriesViewHolder
                holder.setCategories(home[position])
            }
        }
    }

    inner class CarouselHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setCarousel(home : Home){
            val carouselAdapter = HomeCarouselAdapter(home.flashBanner)
            itemView.vp_carousel.adapter = carouselAdapter
        }
    }

    inner class SixGridViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setupSixGridImage(home : Home) {
            itemView.tv_header_menu.text = home.name
            itemView.rv_home_menu.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            val sixGridImageAdapter = SixGridImageAdapter(context, home.images)
            itemView.rv_home_menu.adapter = sixGridImageAdapter
        }
    }

    inner class MenuViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setMenu(home: Home){
            itemView.tv_header_menu.text = home.name
            itemView.rv_home_menu.layoutManager = GridLayoutManager(context,4, GridLayoutManager.VERTICAL, false)
            val homeMenuAdapter = MenuGridAdapter(home.homeMenu)
            itemView.rv_home_menu.adapter = homeMenuAdapter
            //itemView.rv_home_menu.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
    }

    inner class PromoBannerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setPromoBanner(home : Home){
            itemView.tv_header_menu.text = context.getString(R.string.today_promo)
            itemView.rv_home_menu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val promoBannerAdapter = PromoBannerAdapter(home.promoBanners)
            itemView.rv_home_menu.adapter = promoBannerAdapter
        }
    }

    inner class TwoRowGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setTwoRowGrid(home: Home){
            itemView.rv_home_menu.layoutManager = GridLayoutManager(context,2, GridLayoutManager.HORIZONTAL, false)
            val twoRowGridAdapter = TwoRowGridAdapter(home)
            itemView.rv_home_menu.adapter = twoRowGridAdapter
        }
    }

    inner class TopProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setTopProduct(home: Home){
            itemView.tv_header_menu.text = context.getString(R.string.top_products)
            itemView.rv_home_menu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val topProductAdapter = TopProductAdapter(home.products)
            itemView.rv_home_menu.adapter = topProductAdapter
        }
    }

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setCategories(home : Home){
            itemView.tv_header_menu.text = context.getString(R.string.category_product)
            itemView.rv_home_menu.layoutManager = GridLayoutManager(context,2, GridLayoutManager.HORIZONTAL, false)
            val categoriesAdapter = CategoriesAdapter(home.categories as ArrayList<Category>)
            itemView.rv_home_menu.adapter = categoriesAdapter
        }
    }

}