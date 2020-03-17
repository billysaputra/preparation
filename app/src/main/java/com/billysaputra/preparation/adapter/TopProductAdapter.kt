package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Product
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_top_product.view.*

class TopProductAdapter(private val products : List<Product>) : RecyclerView.Adapter<TopProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setTopProduct(products[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setTopProduct(product : Product){
            Glide.with(itemView.iv_product.context)
                .load(product.images[0])
                .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                .into(itemView.iv_product)
            itemView.tv_product_name.text = product.name
            itemView.tv_original_price.text = "Rp"+product.dealInfo?.originalPrice.toString()
            itemView.tv_discount_price.text = "Rp"+product.dealInfo?.discountPrice.toString()
            if(product.dealInfo?.discountPercentage !=0){
                itemView.tv_discount_percent.visibility = View.VISIBLE
                itemView.tv_discount_percent.text = product.dealInfo?.discountPercentage.toString() + "%"
            }else{
                itemView.tv_discount_percent.visibility = View.GONE
            }
        }
    }
}