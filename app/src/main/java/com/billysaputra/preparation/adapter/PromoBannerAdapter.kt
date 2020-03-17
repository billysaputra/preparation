package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.PromoBanner
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_promo_banner.view.*

class PromoBannerAdapter(var promoBannerList : List<PromoBanner>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_promo_banner, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return promoBannerList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        holder.setBanner(promoBannerList[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setBanner(promoBanner : PromoBanner){
            Glide.with(itemView.iv_banner.context)
                .load(promoBanner.image)
                .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                .into(itemView.iv_banner)
            itemView.tv_promo_desc.text = promoBanner.description
        }
    }
}