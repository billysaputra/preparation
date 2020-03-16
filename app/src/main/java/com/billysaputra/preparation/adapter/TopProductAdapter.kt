package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Home
import com.billysaputra.preparation.data.model.TopProduct
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_top_product.view.*

class TopProductAdapter(val home : Home) : RecyclerView.Adapter<TopProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return home.topProducts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setTopProduct(home.topProducts[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setTopProduct(topProduct : TopProduct){
            Glide.with(itemView.iv_product.context)
                .load(topProduct.productImage)
                .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                .into(itemView.iv_product)
            itemView.tv_product_name.text = topProduct.productName
            itemView.tv_product_price.text = topProduct.productPrice
        }
    }
}