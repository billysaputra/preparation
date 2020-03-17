package com.billysaputra.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.data.model.Category
import kotlinx.android.synthetic.main.item_categories.view.*

class CategoriesAdapter(var categories : ArrayList<Category>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setCategories(categories[position])
    }

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun setCategories(category : Category){
            /*Glide.with(itemView.iv_categories.context)
                .load(category.image)
                .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                .into(itemView.iv_categories)*/
            itemView.tv_categories.text = category.name
        }
    }
}