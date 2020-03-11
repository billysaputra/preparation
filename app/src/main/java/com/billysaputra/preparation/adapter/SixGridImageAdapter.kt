package com.billysaputra.preparation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import com.billysaputra.preparation.helper.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_grid.view.*

/**
 * Created by Billy Saputra on 2020-03-11.
 */
class SixGridImageAdapter(var context : Context, var imageList : List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return SixGridImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sixGridImageViewHolder = holder as SixGridImageViewHolder
        sixGridImageViewHolder.setSixGridImage(position)
        sixGridImageViewHolder.setSixGridImageOnClick(position)
    }


    inner class SixGridImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setSixGridImage(position: Int){
            if(position % 2 == 0){
                itemView.ll_six_grid.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            }else {
                itemView.ll_six_grid.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
            }
            Glide.with(itemView.iv_six_grid.context)
                .load(imageList[position])
                .apply(Utils.glideRequestOptions(R.drawable.ic_placeholder))
                .into(itemView.iv_six_grid)

        }

        fun setSixGridImageOnClick(position: Int){
            itemView.iv_six_grid.setOnClickListener {
                //homeFragmentView.onSixGridImageClick()
            }
        }
    }
}
