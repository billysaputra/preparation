package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.HomeMenu
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_menu.view.*

/**
 * Created by Billy Saputra on 2020-03-12.
 */
class MenuGridAdapter(private var menuList : List<HomeMenu>) : RecyclerView.Adapter<MenuGridAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.setView(menuList[position])
    }

    inner class MenuViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setView(menu : HomeMenu){
            with(itemView){
                Glide.with(iv_menu.context)
                    .load(menu.menuImageUrl)
                    .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                    .into(iv_menu)
                tv_menu.text = menu.menuName
            }
        }
    }
}