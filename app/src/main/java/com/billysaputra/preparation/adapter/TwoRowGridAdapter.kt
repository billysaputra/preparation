package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Home
import com.billysaputra.preparation.data.model.HomeMenu
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_two_row_grid.view.*

class TwoRowGridAdapter(private var menuList: Home) :
    RecyclerView.Adapter<TwoRowGridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_two_row_grid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.homeMenu.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setTwoRowGrid(menuList.homeMenu[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setTwoRowGrid(menu: HomeMenu) {
            Glide.with(itemView.iv_menu.context)
                .load(menu.menuImageUrl)
                .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                .into(itemView.iv_menu)
            itemView.tv_menu.text = menu.menuName
        }
    }

}