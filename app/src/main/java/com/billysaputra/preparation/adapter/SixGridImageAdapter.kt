package com.billysaputra.preparation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.billysaputra.preparation.R
import kotlinx.android.synthetic.main.item_grid.view.*

/**
 * Created by Billy Saputra on 2020-03-11.
 */
class SixGridImageAdapter(var context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var sixGridImageList : MutableList<Int> = ArrayList()
    fun reloadSixGridImage(sixGridImageList : MutableList<Int>){
        this.sixGridImageList = sixGridImageList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false)
        return SixGridImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sixGridImageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sixGridImageViewHolder = holder as SixGridImageViewHolder
        sixGridImageViewHolder.setSixGridImage(position)
        sixGridImageViewHolder.setSixGridImageOnClick(position)
    }


    inner class SixGridImageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun setSixGridImage(position: Int){
            if(position % 2 == 0){
                itemView.ll_six_grid.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            }else {
                itemView.ll_six_grid.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
            }
            //Glide.with(context).load(R.drawable.ic_menu_inspeksi_motor_new).placeholder(R.drawable.promo_placeholder).dontAnimate().into(itemView.six_grid_image)
            itemView.iv_six_grid.setImageResource(sixGridImageList[position])
        }

        fun setSixGridImageOnClick(position: Int){
            itemView.iv_six_grid.setOnClickListener {
                //homeFragmentView.onSixGridImageClick()
            }
        }
    }
}
