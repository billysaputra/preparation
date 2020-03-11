package com.billysaputra.preparation.helper

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Billy Saputra on 2020-03-11.
 */
class CustomLinearItemDecoration(private val spaceHeight: Int, private var orientation : Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if(orientation == LinearLayoutManager.HORIZONTAL){
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    left = spaceHeight
                }
                top = spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }else{
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceHeight
                }
                left =  spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }
    }
}